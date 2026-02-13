package com.sahil.taskmanager.repository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {
    public TaskRepository(){
        System.out.println("📦Repository layer created!");
    }

    public void saveTask(String title){
        System.out.println("DB: Saving task -> "+title);
    }
}
