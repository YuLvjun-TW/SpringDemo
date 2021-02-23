package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    private final JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String queryUserNameById(int id) {
        String sql = "select * from user where id = " + "\"" + id + "\"";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
        return stringObjectMap.get("name").toString();
    }
}
