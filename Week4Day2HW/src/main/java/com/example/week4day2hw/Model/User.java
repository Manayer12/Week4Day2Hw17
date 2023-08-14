package com.example.week4day2hw.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "should not be null")
    @Size(min = 5,message = "name should be more than 4 letters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "should not be null")
    @Column(columnDefinition = "varchar(20) unique not null")
    @Size(min = 5,message = "username should be more than 4 letters")
    private String username;

    @NotEmpty(message = "should not be null")
    @Column(columnDefinition = "varchar(25) not null")
    private  String password;

    @NotEmpty(message = "should not be null")
    @Column(columnDefinition = "varchar(25) unique not null")
    @Email
    private String email;

    @NotEmpty(message = "should not be null")
    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp = "Admin|Customer")
    private String role;

    @NotNull
    @Positive
    private int age;





}
