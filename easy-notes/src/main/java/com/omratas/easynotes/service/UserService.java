package com.omratas.easynotes.service;

import com.omratas.easynotes.model.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    List<User> findAllUsers();
}
