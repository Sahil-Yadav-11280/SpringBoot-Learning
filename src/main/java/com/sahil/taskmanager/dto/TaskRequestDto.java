package com.sahil.taskmanager.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDto {

    @NotBlank(message = "Title cannot be empty!")
    @Size(min = 3,max = 255, message = "Title must be between 3 and 255 characters")
    private String title;

    @Size(max = 500, message = "description is too long!")
    private String description;

    @NotBlank(message = "Username is compulsory")
    private String ownerUsername;
}
