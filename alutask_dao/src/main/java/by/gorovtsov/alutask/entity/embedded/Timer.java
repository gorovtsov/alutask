package by.gorovtsov.alutask.entity.embedded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class Timer {
    private LocalDateTime start;
    private LocalDateTime end;

    public Timer(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }
}
