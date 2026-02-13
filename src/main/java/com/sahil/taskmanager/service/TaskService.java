package com.sahil.taskmanager.service;

import com.sahil.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.awt.desktop.SystemEventListener;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        System.out.println("🧑‍🍳Service layer created (Repository injected)");
    }

    public void createTask(String title){
        System.out.println("Service: Validating Task...");
        taskRepository.saveTask(title);
    }
}
