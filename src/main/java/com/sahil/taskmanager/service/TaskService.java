package com.sahil.taskmanager.service;

import com.sahil.taskmanager.model.Task;
import com.sahil.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        System.out.println("🧑‍🍳 Service layer created!");
    }

    public List<Task> getAllTasks(){return taskRepository.findAll();}

    public Task getTaskById(Integer id){return taskRepository.findById(id);}

    public Task createTask(Task task){
        task.setId((int) (Math.random()*1000));
        return taskRepository.save(task);
    }
}
