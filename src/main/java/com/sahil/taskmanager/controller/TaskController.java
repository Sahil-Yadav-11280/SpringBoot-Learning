package com.sahil.taskmanager.controller;

import com.sahil.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
        System.out.println("🎮TaskController: Bean created and service injected");
    }

    @GetMapping("/create-task")
    public String create(){
        taskService.createTask("Learn Springboot!");
        return "Task created successfully";
    }
}
