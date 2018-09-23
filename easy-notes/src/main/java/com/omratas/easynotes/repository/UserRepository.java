package com.omratas.easynotes.repository;

import com.omratas.easynotes.model.User;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface UserRepository extends CrudRepository<User, Serializable> {

    User findByUsername(String username);
}
