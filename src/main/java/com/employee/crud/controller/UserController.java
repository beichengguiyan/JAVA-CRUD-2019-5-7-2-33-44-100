package com.employee.crud.controller;

import com.employee.crud.entity.Employee;
import com.employee.crud.exception.BusinessException;
import com.employee.crud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
//ToDo:在上一行代码("")中填写合适的RestfulApi
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/post")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity addUser(@RequestBody Employee user) {
        userService.addUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/put/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity updateUserById(@PathVariable int userId, @RequestBody Employee user) throws BusinessException {
        userService.updateUserById(userId, user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{userId}")
    //ToDo:在上一行代码("")中填写合适的RestfulApi
    public ResponseEntity deleteUserById(@PathVariable int userId) throws BusinessException {
        userService.deleteUserById(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
