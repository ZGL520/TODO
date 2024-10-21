package com.todo.ztodo.service;
import com.todo.ztodo.entity.UserEntity;
import com.todo.ztodo.repository.UserRepository;
import com.todo.ztodo.utils.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity saveUser(UserEntity user) {
        List<UserEntity> users = userRepository.findByEmail(user.getEmail());
        if(!users.isEmpty()) {
            throw new CommonException("User already exists");
        }
        return userRepository.save(user);
    }

    public List<UserEntity> getUserByEmail(String email) {
        List<UserEntity> user = userRepository.findByEmail(email);
        return  userRepository.findByEmail(email);
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Long deleteUser(String email) {
        List<UserEntity> user = userRepository.findByEmail(email);
        Long id = (long) -1;
        if(!user.isEmpty()) {
            id = user.get(0).getId();
            userRepository.deleteById(id);
        }
        return id;
    }
}
