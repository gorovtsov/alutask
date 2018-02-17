package by.gorovtsov.alutask.entity.project;

import by.gorovtsov.alutask.entity.BaseEntity;
import by.gorovtsov.alutask.entity.embedded.Timer;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.entity.user.Manager;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.Column;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "projects")
public class Project extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "projects_developers",
            joinColumns = { @JoinColumn(name = "project_id")},
            inverseJoinColumns =  { @JoinColumn(name = "developer_id")}
    )
    private Set<Developer> developers = new HashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks;

    @Column(name = "description", nullable = false)
    private String description;

    @AttributeOverrides(value = {
            @AttributeOverride(name = "start", column = @Column(name = "open_time", nullable = false)),
            @AttributeOverride(name = "end", column = @Column(name = "end_time", nullable = false))
    })
    private Timer timer;

    public void addDeveloper(Developer developer) {
        this.developers.add(developer);
    }

    public Project(Manager manager, String name, String description, Timer timer) {
        this.manager = manager;
        this.name = name;
        this.description = description;
        this.timer = timer;
    }
}
