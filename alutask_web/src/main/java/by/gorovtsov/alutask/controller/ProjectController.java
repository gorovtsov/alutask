package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.project.Task;
import by.gorovtsov.alutask.service.ProjectService;
import by.gorovtsov.alutask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProjectController {

    private ProjectService projectService;

    private TaskService taskService;

    @Autowired
    public ProjectController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @ModelAttribute("projects")
    public List<Project> projects() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return projectService.findProjectsByManagerUsername(username);
    }

    @GetMapping("/projects")
    public String showProjectsByManager(Model model) {
        return "projects";
    }

    @GetMapping("/project/{projectId}")
    public String showProjectPage( @PathVariable("projectId") Long projectId, Model model) {


        Project project = projectService.findById(projectId);
        List<Task> tasks = taskService.getHot5TasksByProjectName(project.getName());
        model.addAttribute("project", project);
        model.addAttribute("tasks", tasks);
        return "project";
    }

    @GetMapping("/projects/{projectId}/tasks/{pageNum}")
    public String tasks(@PathVariable("pageNum") int pageNum,
                        @PathVariable("projectId")Long projectId,
                        Model model) {
        pageNum--;
        List<Task> tasks = taskService.getTaskPageByProjectId(projectId, pageNum, 5);
        List<Integer> pageNumbers = taskService.getPageNumbersByProjectId(projectId);
        model.addAttribute("projectId", projectId);
        model.addAttribute("pageNums", pageNumbers);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
