package by.gorovtsov.alutask.entity.user;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.enumeration.Department;
import by.gorovtsov.alutask.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "managers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Manager extends User {

    @Column(name = "department", nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToMany(mappedBy = "manager")
    private Set<Project> projects;

    public Manager(String name, String login, String email, String password,
                     Department department) {
        super(name, login, email, password, Role.MANAGER);
        this.department = department;
    }
}
