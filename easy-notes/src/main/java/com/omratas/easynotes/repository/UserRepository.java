package com.omratas.easynotes.repository;

import com.omratas.easynotes.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {
}
