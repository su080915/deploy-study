package com.example.deploystudy.service;


import com.example.deploystudy.repository.DeployRepository;
import com.example.deploystudy.repository.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeployService {
    private final DeployRepository deployRepository;

    public void save() {
        Message message = new Message();
        deployRepository.save(message);
    }
}
