package by.gorovtsov.alutask.entity.message;

import by.gorovtsov.alutask.entity.project.Task;
import by.gorovtsov.alutask.entity.user.User;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class Comment extends BaseDialog {

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    public Comment(User author, String message, LocalDateTime creationTime, Task task) {
        super(author, message, creationTime);
        this.task = task;
    }
}