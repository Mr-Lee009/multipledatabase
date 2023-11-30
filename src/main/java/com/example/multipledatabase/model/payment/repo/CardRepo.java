package com.example.multipledatabase.model.payment.repo;

import com.example.multipledatabase.model.payment.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//classpath:/database_config
public interface CardRepo extends JpaRepository<Card,Long> {
}
