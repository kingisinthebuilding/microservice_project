package com.microservice.userservice.service;

import com.microservice.userservice.model.User;

import java.util.List;

public interface UserService
{
    //create
    User saveUser(User user);

    //read all
    List<User> getAllUser();

    //read by id
    User getUserById(String id);

    //update
    User updateUser(String id, User updatedUser);

    // Delete
    void deleteUserById(String id);
}
