package com.sahil.taskmanager.repository;

import com.sahil.taskmanager.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class TaskRepository {
    public TaskRepository(){System.out.println("📦 Repository layer created!");}

    private List<Task> tasks = new ArrayList<>();

    public List<Task> findAll(){return tasks;}
    public Task findById(Integer id){
        for(Task task:tasks){
            if(Objects.equals(task.getId(), id)){
                return task;
            }
        }
        return null;
    }
    public Task save(Task task){
        tasks.add(task);
        return task;
    }

    public Task delete(Task task){
        tasks.remove(task);
        return task;
    }

}
