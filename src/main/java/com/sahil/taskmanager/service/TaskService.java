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

    public Task getTaskById(Integer id){return taskRepository.findById(id).orElse(null);}

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTitle(Integer id, String title){
        Task task = getTaskById(id);
        if(task != null){
            task.setTitle(title);
            return taskRepository.save(task);
        }
        return null;
    }

    public Task updateCompleted(Integer id, boolean completed){
        Task task = getTaskById(id);
        if(task != null){
            task.setCompleted(completed);
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Integer id){
        taskRepository.deleteById(id);
    }
}
