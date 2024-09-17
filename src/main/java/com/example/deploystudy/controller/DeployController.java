package com.example.deploystudy.controller;


import com.example.deploystudy.service.DeployService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeployController {
    private final DeployService deployService;

    @PostMapping("/here")
    public void creat() {
        deployService.save();
    }
}
