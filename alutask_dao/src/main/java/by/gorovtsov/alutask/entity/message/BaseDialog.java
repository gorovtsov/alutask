package by.gorovtsov.alutask.entity.message;

import by.gorovtsov.alutask.entity.BaseEntity;
import by.gorovtsov.alutask.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseDialog extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "sending_time", nullable = false)
    private LocalDateTime creationTime;

    protected BaseDialog(User author, String message, LocalDateTime creationTime) {
        this.author = author;
        this.message = message;
        this.creationTime = creationTime;
    }
}
