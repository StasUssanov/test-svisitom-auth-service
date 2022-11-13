package com.example.testsvisitomauthservice.token.service;

import com.example.testsvisitomauthservice.session.entity.SessionEntity;
import com.example.testsvisitomauthservice.session.exception.SessionNotFoundException;
import com.example.testsvisitomauthservice.token.dto.response.TokenResponse;
import com.example.testsvisitomauthservice.token.exception.TokenFailException;
import com.example.testsvisitomauthservice.token.exception.TokenWrongException;
import com.example.testsvisitomauthservice.token.exception.UsernameOrPasswordWrongException;
import com.example.testsvisitomauthservice.user.dto.request.UserRequest;
import com.example.testsvisitomauthservice.user.entity.UserEntity;
import com.example.testsvisitomauthservice.user.exception.UserNotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class TokenService extends TokenBaseService {

    public TokenResponse createTokens(UserRequest userRequest) throws UserNotFoundException, UsernameOrPasswordWrongException {
        Optional<UserEntity> user = userRepository.findAllByUsername(userRequest.getUsername());
        if (user.isEmpty()) throw new UserNotFoundException();

        if (!Objects.equals(user.get().getPassword(), userRequest.getPassword()))
            throw new UsernameOrPasswordWrongException();

        return this.buildTokens(user.get());
    }

    private TokenResponse buildTokens(UserEntity user) {
        SessionEntity session = SessionEntity.builder()
                .user(user)
                .start(new Date())
                .expiration(this.getExpiration(refreshTokenLifeTimeMinutes))
                .build();

        sessionRepository.save(session);
        return new TokenResponse(
                this.buildAccessToken(user, session),
                this.buildRefreshToken(session)
        );
    }

    private String buildAccessToken(UserEntity user, SessionEntity session) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("typ", "Bearer");
        claims.put("session", session.getUuid());

        String[] roleList = {"testRole"};
        claims.put("roleList", roleList);

        claims.put("username", user.getUsername());

        return Jwts.builder()
                .setIssuedAt(session.getStart())
                .setExpiration(this.getExpiration(accessTokenLifeTimeMinutes))
                .setSubject(session.getUser().getUuid())
                .addClaims(claims)
                .signWith(this.getKey())
                .compact();
    }

    private String buildRefreshToken(SessionEntity session) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("typ", "Refresh");
        claims.put("session", session.getUuid());

        return Jwts.builder()
                .setIssuedAt(session.getStart())
                .setExpiration(session.getExpiration())
                .setSubject(session.getUser().getUuid())
                .addClaims(claims)
                .signWith(this.getKey())
                .compact();
    }

    private Date getExpiration(Integer minutes) {
        return new Date(System.currentTimeMillis() + (minutes * 60000));
    }

    public TokenResponse refreshTokens(String token) throws Exception {
        try {
            Claims claims = this.parseToken(token);

            if (!Objects.equals(claims.get("typ"), "Refresh")) throw new TokenWrongException();

            String sessionUid = claims.get("session").toString();
            this.destroySession(sessionUid);

            Optional<UserEntity> user = userRepository.findById(claims.getSubject());
            if (user.isEmpty()) throw new UserNotFoundException();

            return buildTokens(user.get());
        } catch (JwtException exception) {
            throw new TokenFailException();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String killTokens(String token) throws Exception {
        try {
            Claims claims = parseToken(token);

            if (!Objects.equals(claims.get("typ"), "Bearer")) throw new TokenWrongException();

            String sessionUuid = claims.get("session").toString();
            return destroySession(sessionUuid);
        } catch (JwtException exception) {
            throw new TokenFailException();
        }
    }

    private Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretString));
    }

    private String destroySession(String sessionUid) throws Exception {
        if (sessionRepository.findById(sessionUid).isEmpty()) throw new SessionNotFoundException();
        sessionRepository.deleteById(sessionUid);
        return sessionUid;
    }
}
