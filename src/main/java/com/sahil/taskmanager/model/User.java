package com.sahil.taskmanager.model;


import jakarta.jws.Oneway;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false , unique = true)
    private String username;

//    THE RELATIONSHIP (One-To-Many)
//    One user is linked to a list of Tasks
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Task> tasks;
}
