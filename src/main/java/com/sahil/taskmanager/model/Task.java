package com.sahil.taskmanager.model;

public class Task {
    private int id;
    private String title;
    private boolean completed;

//    Default constructor needed for JSON parsing
    public Task(){};

//    Constructor
    public Task(int id , String title){
        this.id = id;
        this.title = title;
    }

//    getters and setters:
    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
}
