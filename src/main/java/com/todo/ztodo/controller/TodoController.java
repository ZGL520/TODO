package com.todo.ztodo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TodoController {
    @GetMapping("/hello")
    @ResponseBody
    public Map<String, String> index() {
        return Map.of("message", "Hello, World!");
    }
}