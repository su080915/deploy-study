package com.example.deploystudy.controller;


import com.example.deploystudy.service.DeployService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeployController {
    private final DeployService deployService;

    @GetMapping("/here")
    public void index() {
        deployService.save();
    }
}
