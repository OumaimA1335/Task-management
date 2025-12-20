package com.TaskManagement.main.Controllers;

import com.TaskManagement.main.DTO.TaskRequest;
import com.TaskManagement.main.Entities.Task;
import com.TaskManagement.main.Services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest task) {
        log.info("Creating task title={} userId={}",
                task.getTitle(),
                task.getUser_id());
        return ResponseEntity.ok().body(taskService.add(task));
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        log.info("Getting task with id={}", id);
        return ResponseEntity.ok().body(taskService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        log.info("Getting all tasks");
        return ResponseEntity.ok().body(taskService.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        log.info("Deleting task with id={}", id);
        return ResponseEntity.ok(taskService.delete(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long id,
            @RequestBody Map<String, String> mapStatus) {
        log.info("Updating task with id={}", id);
        String status = mapStatus.get("status");
        Task updatedTask = taskService.updateTask(id, status);
        return ResponseEntity.ok(updatedTask);
    }





}
