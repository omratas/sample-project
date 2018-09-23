package com.omratas.easynotes.repository;

import com.omratas.easynotes.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface PostRepository extends CrudRepository<Post, Serializable> {
}
