package by.gorovtsov.alutask.entity.user;

import by.gorovtsov.alutask.entity.BaseEntity;
import by.gorovtsov.alutask.entity.message.Letter;
import by.gorovtsov.alutask.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

import javax.persistence.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString(exclude = {"emailContainer", "password"})
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "recievers")
    private Set<Letter> emailContainer;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(String name, String login, String email, String password, Role role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}