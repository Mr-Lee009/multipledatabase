package com.example.multipledatabase.service;

import com.example.multipledatabase.model.app.model.User;
import com.example.multipledatabase.model.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppService {
    User add(User user);

    User update(User user);

    boolean delete(long Id);

    List<User> findAll();
}
