package com.example.week4day2hw.Service;

import com.example.week4day2hw.Model.User;
import com.example.week4day2hw.Repostery.UserRepostery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

        private final UserRepostery userRepostery;
        public List<User> getAllUser(){
            return userRepostery.findAll();
            //return list
        }


       public void addUser(User user){

        userRepostery.save(user);
         }

        public Boolean updateUser(Integer id,User user){
        User oldUser=userRepostery.getById(id);
        if (oldUser==null){
            return false;
        }
        oldUser.setName(user.getName());
        oldUser.setUsername(oldUser.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        oldUser.setAge(user.getAge());
        oldUser.setName(user.getName());
        userRepostery.save(oldUser);
        return true;

         }

       public Boolean deleteUser(Integer id){
        User deleteUser=userRepostery.getById(id);
        if (deleteUser==null){
            return false;
        }
        userRepostery.delete(deleteUser);
        return true;  }





}
