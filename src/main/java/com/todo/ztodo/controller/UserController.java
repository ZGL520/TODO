package com.todo.ztodo.controller;
import com.todo.ztodo.entity.UserEntity;
import com.todo.ztodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("createUser")
    @ResponseBody
    public  UserEntity createUser(@RequestParam String name, @RequestParam String email) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setEmail(email);
        return userService.saveUser(user);
    }

    @GetMapping("/getUserByEmail")
    @ResponseBody
    public List<UserEntity> getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/deleteUser")
    @ResponseBody
    public Long deleteUser(@RequestParam String email) {
        return  userService.deleteUser(email);
    }
}
