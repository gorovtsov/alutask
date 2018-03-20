package by.gorovtsov.alutask.controller;

import by.gorovtsov.alutask.entity.project.Project;
import by.gorovtsov.alutask.entity.project.Task;
import by.gorovtsov.alutask.service.ProjectService;
import by.gorovtsov.alutask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OptimisticLockException;
import java.util.List;

@Controller
@SessionAttributes({"pageNums", "projectNames", "project", "task"})
public class TaskController {

    private TaskService taskService;
    private ProjectService projectService;

    @Autowired
    public TaskController(TaskService service, ProjectService projectService) {
        this.taskService = service;
        this.projectService = projectService;
    }

    @ModelAttribute
    public List<Project> availableActiveProjects() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return projectService.findProjectsByManagerUsername(username);
    }



    @GetMapping("/task/{taskId}")
    public String showTask(@PathVariable("taskId") Long taskId, Model model ) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task" , task);
        return "task";
    }

    @GetMapping("/task/{taskId}/edit")
    public String editTask(@PathVariable("taskId") Long taskId, Model model) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("project", task.getProject());
        model.addAttribute("task", task);
        return "taskForm";
    }

    @GetMapping("/task/new")
    public String taskForm(Model model) {
        model.addAttribute("task" , new Task());
        return "taskForm";
    }

    @PostMapping("/task/new")
    public String persistTask(Task task, Model model) {

        try {
            taskService.saveTask(task);
        } catch (OptimisticLockException ex) {
            return "redirect:/task/" + task.getId();
        }
        model.addAttribute("task", task);
        return "task";
    }
}