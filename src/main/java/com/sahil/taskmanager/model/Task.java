package com.sahil.taskmanager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity //Tells hibernate: "Make a table out of this class"
//Using lombok annotations:
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id //Tells hibernate: "This is a primary key"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // "Auto increment this id for me (1,2,3...)"
    private Integer id;
    private String title;
    private boolean completed;

}
