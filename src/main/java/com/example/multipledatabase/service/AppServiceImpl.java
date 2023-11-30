package com.example.multipledatabase.service;

import com.example.multipledatabase.model.app.model.User;
import com.example.multipledatabase.model.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    UserRepo repository;

    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public boolean delete(long Id) {
        if (repository.findById(Id) == null) {
            return false;
        }
        repository.deleteById(Id);
        return true;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
