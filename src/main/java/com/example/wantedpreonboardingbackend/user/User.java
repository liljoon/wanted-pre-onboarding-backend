package com.example.wantedpreonboardingbackend.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JOB_USER")
public class User {
    @Id
    @GeneratedValue
    private Long userId;

    private String name;
    private String id;
    private String password;
}
