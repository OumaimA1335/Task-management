package com.TaskManagement.main.Controllers;

import com.TaskManagement.main.Entities.Task;
import com.TaskManagement.main.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("Task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        taskService.add(task);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok().body(taskService.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.delete(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Map<String, String> mapStatus) {
        String status = mapStatus.get("status");
        Task updatedTask = taskService.updateTask(id, status);
        return ResponseEntity.ok(updatedTask);
    }





}
