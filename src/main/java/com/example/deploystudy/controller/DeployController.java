package com.example.deploystudy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeployController {

    @GetMapping
    public String index() {
        return "Deploy!";
    }
}
