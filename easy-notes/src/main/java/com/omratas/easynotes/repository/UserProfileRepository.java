package com.omratas.easynotes.repository;

import com.omratas.easynotes.model.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Serializable> {
}
