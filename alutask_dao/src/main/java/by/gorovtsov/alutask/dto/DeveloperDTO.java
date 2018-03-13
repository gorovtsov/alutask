package by.gorovtsov.alutask.dto;

import by.gorovtsov.alutask.enumeration.DeveloperLevel;
import by.gorovtsov.alutask.enumeration.ProgrammingLanguage;
import by.gorovtsov.alutask.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeveloperDTO {

    private int pageSize;

    private String name;

    private String email;

    private String login;

    private String password;

    private Role role;

    private ProgrammingLanguage language;

    private DeveloperLevel level;
}
