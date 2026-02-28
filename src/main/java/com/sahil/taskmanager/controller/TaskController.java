package com.sahil.taskmanager.controller;

import com.sahil.taskmanager.dto.TaskDto;
import com.sahil.taskmanager.dto.TaskRequestDto;
import com.sahil.taskmanager.model.Task;
import com.sahil.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
        System.out.println("🎮 Controller layer created!");
    }

    @GetMapping
//    public List<Task> getAllTask(){return taskService.getAllTasks();}
    public List<TaskDto> getAllTask(){return taskService.getAllTasksSafe();}

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Integer id){return taskService.getTaskById(id);}

    @PostMapping
    public TaskDto createTaskSafe(@Valid @RequestBody TaskRequestDto incomingDto){return taskService.createTaskSafe(incomingDto);}
//    public Task createTask(@RequestBody Task task){
//        return taskService.createTask(task);
//    }

    @PatchMapping("/{id}/title")
    public Task updateTitle(@PathVariable Integer id , @RequestBody Task task){
        return taskService.updateTitle(id,task.getTitle());
    }

    @PatchMapping("/{id}/completed")
    public Task updateCompleted(@PathVariable Integer id , @RequestBody Task task){
        return taskService.updateCompleted(id , task.isCompleted());
    }

    @PatchMapping("/{id}/description")
    public Task updateDescription(@PathVariable Integer id, @RequestBody Task task){
        return taskService.updateDescription(id,task.getDesc());
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
    }

    @GetMapping("/pending")
    public List<Task> pendingTasks(){
        return taskService.pendingTasks();
    }

    @GetMapping("/sabotage")
    public String triggerSabotage(){
        taskService.testTransactionRollback();
        return "this will never return because of system crash";
    }
}
