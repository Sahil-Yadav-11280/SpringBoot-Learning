package com.sahil.taskmanager.model;

public class Task {
    private Integer id;
    private String title;
    private boolean completed;

//    default constructor for JSON parsing
    public Task(){}

    public Task(Integer id , String title , boolean completed){
        this.id = id;
        this.title=title;
        this.completed=completed;
    }

//    getters and setters
    public Integer getId(){return this.id;}
    public void setId(Integer id){this.id=id;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title=title;}

    public boolean getCompleted(){return this.completed;}
    public void setCompleted(boolean completed){this.completed = completed;}
}
