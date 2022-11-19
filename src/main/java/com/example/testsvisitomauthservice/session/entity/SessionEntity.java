package com.example.testsvisitomauthservice.session.entity;

import com.example.testsvisitomauthservice.user.entity.UserEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", length = 36, unique = true, updatable = false, nullable = false)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "user_uuid", unique = true, referencedColumnName = "uuid", columnDefinition = "VARCHAR(36)")
    UserEntity user = null;

    @Column(name = "start", columnDefinition = "DATETIME")
    private Date start;

    @Column(name = "expiration", columnDefinition = "DATETIME")
    private Date expiration;
}
