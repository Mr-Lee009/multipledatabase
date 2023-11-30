package com.example.multipledatabase.controller;


import com.example.multipledatabase.model.app.model.User;
import com.example.multipledatabase.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    AppService appService;

    @GetMapping(value = "find-all")
    public List<User> findAll(){
        return appService.findAll();
    }
}
