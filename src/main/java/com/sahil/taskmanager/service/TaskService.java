package com.sahil.taskmanager.service;

import com.sahil.taskmanager.dto.TaskDto;
import com.sahil.taskmanager.dto.TaskRequestDto;
import com.sahil.taskmanager.exception.ResourceNotFoundException;
import com.sahil.taskmanager.model.Task;
import com.sahil.taskmanager.model.User;
import com.sahil.taskmanager.repository.TaskRepository;
import com.sahil.taskmanager.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    public TaskService(TaskRepository taskRepository , UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        System.out.println("🧑‍🍳 Service layer created!");
    }

    public List<Task> getAllTasks(){return taskRepository.findAll();}

    public Task getTaskById(Integer id){return taskRepository.findById(id).orElse(null);}

    public Task createTask(Task task){
        User defaultUser = userRepository.findById(1).orElse(null);

        if(defaultUser!=null){
            task.setUser(defaultUser);
        }
        return taskRepository.save(task);
    }

    public Task updateTitle(Integer id, String title){
        Task task = getTaskById(id);
        if(task != null){
            task.setTitle(title);
            return taskRepository.save(task);
        }
        return null;
    }

    public Task updateCompleted(Integer id, boolean completed){
        Task task = getTaskById(id);
        if(task != null){
            task.setCompleted(completed);
            return taskRepository.save(task);
        }
        return null;
    }

    public Task updateDescription(Integer id , String desc){
        Task task = getTaskById(id);
        if(task!=null){
            task.setDesc(desc);
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(Integer id){
        taskRepository.deleteById(id);
    }

    public List<Task> pendingTasks(){return taskRepository.getTasksByCompletedFalse();}


//    Sabotaged Method:
    @Transactional
    public void testTransactionRollback(){
        User doomedUser = new User();
        doomedUser.setUsername("doomed_user");
        doomedUser.setEmail("doomed@test.com");

        userRepository.save(doomedUser);

        System.out.println("User saved to database... System about to crash...");

//        Simulate a system failure:
        if(true){
            throw new RuntimeException(("Simulated System Crash!!"));
        }

        Task task = new Task();
        task.setTitle("This task will never exist");
        task.setCompleted(false);
        task.setUser(doomedUser);
        taskRepository.save(task);
    }

    public List<TaskDto> getAllTasksSafe(){
            List<Task> rawTasks = taskRepository.findAll();
            List<TaskDto> safeTasks = new ArrayList<>();

            for (Task task: rawTasks){
                TaskDto dto = new TaskDto();
                dto.setId(task.getId());
                dto.setTitle(task.getTitle());
                dto.setDescription(task.getDesc());
                dto.setCompleted(task.isCompleted());
                dto.setCreatedAt(task.getCreatedAt());

                if(task.getUser()!=null){
                    dto.setOwnerUsername(task.getUser().getUsername());
                }
                safeTasks.add(dto);
            }
            return safeTasks;
    }

    public TaskDto createTaskSafe(@NonNull TaskRequestDto incomingdata){
        Task newEntity = new Task();
        newEntity.setTitle(incomingdata.getTitle());
        newEntity.setDesc(incomingdata.getDescription());

        User owner = userRepository.getUserByUsername(incomingdata.getOwnerUsername());
        if(owner!=null){
            newEntity.setUser(owner);
        }
        else{
            throw new RuntimeException("User not found!");
        }

        Task savedEntity = taskRepository.save(newEntity);

        TaskDto outboundDto = new TaskDto();
        outboundDto.setId(savedEntity.getId());
        outboundDto.setTitle(savedEntity.getTitle());
        outboundDto.setDescription(savedEntity.getDesc());
        outboundDto.setCompleted(savedEntity.isCompleted());
        outboundDto.setCreatedAt(savedEntity.getCreatedAt());
        outboundDto.setOwnerUsername(savedEntity.getUser().getUsername());

        return outboundDto;
    }

    public TaskDto getTaskByIdSafe(Integer id){
        Task taskEntity = taskRepository.findById(id).orElseThrow(()->
            new RuntimeException("task with ID " + id + " was not found in the database")
        );

        TaskDto dto = new TaskDto();
        dto.setId(taskEntity.getId());
        dto.setTitle(taskEntity.getTitle());
        dto.setDescription(taskEntity.getDesc());
        dto.setCompleted(taskEntity.isCompleted());
        dto.setCreatedAt(taskEntity.getCreatedAt());
        dto.setOwnerUsername(taskEntity.getUser().getUsername());

        return dto;
    }
}
