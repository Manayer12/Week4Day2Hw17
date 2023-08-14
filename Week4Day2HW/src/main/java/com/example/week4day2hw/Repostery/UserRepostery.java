package com.example.week4day2hw.Repostery;

import com.example.week4day2hw.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostery extends JpaRepository<User,Integer> {





}


