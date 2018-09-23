package com.omratas.easynotes.repository;

import com.omratas.easynotes.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Serializable> {

    Page<Comment> findByPostIdentifier(String postId, Pageable pageable);
}
