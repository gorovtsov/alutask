package by.gorovtsov.alutask.entity.message;

import by.gorovtsov.alutask.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "letters")
public class Letter extends BaseDialog {

    @ManyToMany
    @JoinTable(
            name = "users_letters",
            joinColumns = { @JoinColumn(name = "author_id")},
            inverseJoinColumns = { @JoinColumn(name = "reciever_id")}
    )
    private Set<User> recievers;

    @Column(name = "topic", nullable = false)
    private String topic;
}
