package com.TaskManagement.main.Services;

import com.TaskManagement.main.Entities.User;
import com.TaskManagement.main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return  null;
    }
}
