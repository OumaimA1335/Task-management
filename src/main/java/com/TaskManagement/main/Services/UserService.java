package com.TaskManagement.main.Services;

import com.TaskManagement.main.Entities.User;
import com.TaskManagement.main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user)
    {
        userRepository.save(user);
    }
    public User getUserById(Long id)
    {
        return userRepository.findById(id).get();
    }
}
