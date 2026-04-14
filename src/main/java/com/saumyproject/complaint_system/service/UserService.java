package com.saumyproject.complaint_system.service;
import com.saumyproject.complaint_system.entity.User;
import com.saumyproject.complaint_system.exception.ResourceNotFoundException;
import com.saumyproject.complaint_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
