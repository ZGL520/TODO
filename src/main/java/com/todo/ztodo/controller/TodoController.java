package com.todo.ztodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TodoController {
    @GetMapping("/hello")
    @ResponseBody
    public Map<String, String> index() {
        return Map.of("message", "Hello, World!");
    }
}