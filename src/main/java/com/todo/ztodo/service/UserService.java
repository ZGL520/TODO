package com.todo.ztodo.service;
import com.todo.ztodo.entity.UserEntity;
import com.todo.ztodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        System.out.println("Fetched users: " + users);
        return users;
    }

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> getUserByEmail(String email) {
        List<UserEntity> user = userRepository.findByEmail(email);
        System.out.println("Fetched user: " + user);
        return  userRepository.findByEmail(email);
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Long deleteUser(String email) {
        List<UserEntity> user = userRepository.findByEmail(email);
        Long id = (long) -1;
        if(user.isEmpty()) {
            System.out.println("User not found");
        }else {
            id = user.get(0).getId();
            userRepository.deleteById(id);
        }
        return id;
    }
}
