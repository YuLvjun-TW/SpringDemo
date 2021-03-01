package com.example.demo.service;

import com.example.demo.listener.CreateNewBookEvent;
import com.example.demo.listener.CreateNewSongEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final ApplicationEventPublisher eventPublisher;

    public UserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public String createNewSong() {
        eventPublisher.publishEvent(CreateNewSongEvent.of("Mr song"));
        return "song";
    }

    public void createNewBook() {
        eventPublisher.publishEvent(CreateNewBookEvent.of("Mr book"));
    }
}
