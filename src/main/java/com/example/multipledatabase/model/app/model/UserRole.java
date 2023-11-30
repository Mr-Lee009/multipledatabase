package com.example.multipledatabase.model.app.model;

import lombok.Data;

import jakarta.persistence.*;


@Entity
@Data
@Table(name = "USER_ROLE")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id")
    private int userId;
    @Column(name = "role_id")
    private int roleId;

}
