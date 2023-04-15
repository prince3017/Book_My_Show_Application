package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTOS.UserEntryDto;
import com.example.BookMyShow.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){

        try{
            userService.addUser(userEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>("User could not add successfully", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-name")
    public ResponseEntity getUserName(@RequestParam("id") Integer id){

        String userName;
        try {
            userName = userService.findUserName(id);
        }catch (Exception e){
            return new ResponseEntity<>("User could not be found", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userName, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-password/{id}")
    public ResponseEntity updateUserPassword(@PathVariable Integer id, @RequestParam("password") String password){

        try {
            userService.updatePassword(id, password);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Password updated successfully", HttpStatus.ACCEPTED);
    }
}
