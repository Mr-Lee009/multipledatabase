package com.example.multipledatabase.model.app.repo;

import com.example.multipledatabase.model.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends JpaRepository<User,Long> {
}
