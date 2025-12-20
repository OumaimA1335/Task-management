package com.TaskManagement.main.Services;

import com.TaskManagement.main.DTO.TaskRequest;
import com.TaskManagement.main.Entities.Task;
import com.TaskManagement.main.Entities.User;
import com.TaskManagement.main.Repository.TaskRepository;
import com.TaskManagement.main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    public Task add(TaskRequest request){

        User user = userRepository.findById(request.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setUser(user);

        return taskRepository.save(task);
    }
    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    public Task findById(long id){
        return taskRepository.findById(id).get();
    }
    public Boolean delete(Long id) {
        if (!taskRepository.existsById(id)) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }

    public Task updateTask(Long id, String status) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setStatus(status);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

}
