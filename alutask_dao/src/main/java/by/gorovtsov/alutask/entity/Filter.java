package by.gorovtsov.alutask.entity;

import by.gorovtsov.alutask.entity.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "filters")
@Data
public class Filter extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "task_creation_time")
    private LocalDateTime taskCreationTime;

    @Column(name = "task_end_time")
    private LocalDateTime taskEndTime;

    @Column(name = "task_execute_time")
    private LocalDateTime taskExecutionTime;

    public Filter(User owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public Filter(User owner, String name, String taskName, String projectName, LocalDateTime taskCreationTime,
                  LocalDateTime taskEndTime, LocalDateTime taskExecutionTime) {
        this.owner = owner;
        this.name = name;
        this.taskName = taskName;
        this.projectName = projectName;
        this.taskCreationTime = taskCreationTime;
        this.taskEndTime = taskEndTime;
        this.taskExecutionTime = taskExecutionTime;
    }
}
