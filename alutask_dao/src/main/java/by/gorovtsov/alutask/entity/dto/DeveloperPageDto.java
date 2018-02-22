package by.gorovtsov.alutask.entity.dto;

import by.gorovtsov.alutask.entity.user.Developer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperPageDto {
    private List<Developer> developers;

    private int totalCount;
}
