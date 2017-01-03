package com.example.bootstrap;

import com.example.model.Message;
import com.example.model.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements ApplicationListener<ApplicationReadyEvent>{

    @Autowired
    private MessageRepository repository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        long count = repository.count();
        if(count == 0){
            Message greeting = new Message("Hello World.");
            repository.save(greeting);
        }
    }
}
