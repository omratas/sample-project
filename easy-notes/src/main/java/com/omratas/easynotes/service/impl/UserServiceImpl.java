package com.omratas.easynotes.service.impl;

import com.omratas.easynotes.model.User;
import com.omratas.easynotes.service.UserService;
import org.hibernate.cfg.NotYetImplementedException;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User findByUsername(String username) {
        throw new NotYetImplementedException();
    }

    @Override
    public List<User> findAllUsers() {
        throw new NotYetImplementedException();
    }
}
