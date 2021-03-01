package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.junit.jupiter.api.Test;
 import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ListenerTest.class)
@ComponentScan(value = "com.example.demo")
public class ListenerTest {
    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCreateNewSongEvent(){
        jdbcTemplate.execute("delete from user where name = 'Mr song'");

        userService.createNewSong();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user where name = 'Mr song'");
        assertEquals(maps.get(0).get("password"), "7890");
    }

    @Test
    public void testCreateNewBookEvent(){
        jdbcTemplate.execute("delete from user where name = 'Mr book'");

        userService.createNewBook();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user where name = 'Mr book'");
        assertEquals(maps.get(0).get("password"), "7890");
    }

    @Test
    public void testOrder(){
        userService.createNewSong();
        userService.createNewBook();
    }
}
