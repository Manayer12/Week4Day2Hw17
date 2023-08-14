package com.example.week4day2hw.Controller;

import com.example.week4day2hw.ApiResponse.ApiResponse;
import com.example.week4day2hw.Model.User;
import com.example.week4day2hw.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUser(){

        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity  addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isupdated=userService.updateUser(id,user);
        if (isupdated){
            return ResponseEntity.status(200).body(new ApiResponse("user updated"));
        }
          return ResponseEntity.status(400).body(new ApiResponse("wrong id"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity  deleteUser(@PathVariable Integer id){

        Boolean isDeleted=userService.deleteUser(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Id"));

    }


}
