package com.example.deploystudy.service;


import com.example.deploystudy.repository.DeployRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeployService {
    private final DeployRepository deployRepository;

    public void save() {
        deployRepository.save("ok");
        System.out.println("ok");
    }
}
