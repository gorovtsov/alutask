package by.gorovtsov.alutask.entity.project;

import by.gorovtsov.alutask.entity.BaseEntity;
import by.gorovtsov.alutask.entity.embedded.Timer;
import by.gorovtsov.alutask.entity.message.Comment;
import by.gorovtsov.alutask.entity.user.Developer;
import by.gorovtsov.alutask.enumeration.TaskStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
public class Task extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "task")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Developer developer;

    @AttributeOverrides(value = {
            @AttributeOverride(name = "start", column = @Column(name = "creation_time", nullable = false)),
            @AttributeOverride(name = "end", column = @Column(name = "execute_time", nullable = false))
    })
    private Timer timer;

    @Column(name = "close_time")
    private LocalDateTime closeTime;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task(Project project, String name, String description, Developer developer, Timer timer) {
        this.project = project;
        this.name = name;
        this.description = description;
        this.developer = developer;
        this.timer = timer;
        this.status = TaskStatus.WAITING;
    }
}
