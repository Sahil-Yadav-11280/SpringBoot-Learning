package com.sahil.taskmanager.service;

import com.sahil.taskmanager.model.Task;
import com.sahil.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    int id = 1;

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        System.out.println("🧑‍🍳 Service layer created!");
    }

    public List<Task> getAllTasks(){return taskRepository.findAll();}

    public Task getTaskById(Integer id){return taskRepository.findById(id);}

    public Task createTask(Task task){
        task.setId(id);
        id++;
        return taskRepository.save(task);
    }

    public Task updateTitle(Integer id, String title){
        Task task = taskRepository.findById(id);
        if(task != null){
            task.setTitle(title);
        }
        return task;
    }

    public Task updateCompleted(Integer id, boolean completed){
        Task task = taskRepository.findById(id);
        if(task != null){
            task.setCompleted(completed);
        }
        return task;
    }

    public Task deleteTask(Integer id){
        Task task = taskRepository.findById(id);
        if(task != null){
            return taskRepository.delete(task);
        }
        return null;
    }
}
