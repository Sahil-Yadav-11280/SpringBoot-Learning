package com.sahil.taskmanager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity //Tells hibernate: "Make a table out of this class"
//Using lombok annotations:
@Table(name = "Task_manager")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id //Tells hibernate: "This is a primary key"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // "Auto increment this id for me (1,2,3...)"
    private Integer id;

    @Column(name = "task_title" , nullable = false , length = 255)
    private String title;

    @Column(name = "task_completed" , nullable = false)
    private boolean completed;

    @Column(name = "description")
    private String desc;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

}
