package com.TaskManagement.main.Services;

import com.TaskManagement.main.Entities.Task;
import com.TaskManagement.main.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void add(Task task){
        taskRepository.save(task);
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
