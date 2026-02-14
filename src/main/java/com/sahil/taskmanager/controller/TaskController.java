package com.sahil.taskmanager.controller;

import com.sahil.taskmanager.model.Task;
import com.sahil.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
        System.out.println("🎮 Controller layer created!");
    }

    @GetMapping
    public List<Task> getAllTask(){return taskService.getAllTasks();}

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id){return taskService.getTaskById(id);}

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

}
