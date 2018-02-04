package by.gorovtsov.alutask.entity.user;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.project.Task;
import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.EnumType;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "developers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Developer extends User {

    @Column(name = "prog_lang", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProgrammingLanguage language;

    @Column(name = "prog_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeveloperLevel level;

    @OneToMany(mappedBy = "developer")
    private Set<Task> tasks = new HashSet<>();

    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects;

    public Developer(String name, String login, String email, String password,
                    ProgrammingLanguage language, DeveloperLevel level) {
        super(name, login, email, password, Role.DEVELOPER);
        this.language = language;
        this.level = level;
    }
}