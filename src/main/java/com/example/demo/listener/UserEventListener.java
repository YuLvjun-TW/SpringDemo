package com.example.demo.listener;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class UserEventListener {
    private final JdbcTemplate jdbcTemplate;

    public UserEventListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void newSongListener(CreateNewSongEvent createNewSongEvent) {
        System.out.println("我成功监听到了事件啦-createNewSongEvent");
        jdbcTemplate.update("insert into user(name,password) value(?, \"7890\")", createNewSongEvent.getSongName());
    }

    @EventListener
    public void newBookListener(CreateNewBookEvent createNewBookEvent) {
        System.out.println(createNewBookEvent.getSongName());
        System.out.println("我成功监听到了事件啦-createNewBookEvent");
        jdbcTemplate.update("insert into user(name,password) value(?, \"7890\")", createNewBookEvent.getSongName());
    }
}
