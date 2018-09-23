package com.omratas.easynotes.repository;

import com.omratas.easynotes.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface NoteRepository extends CrudRepository<Note, Serializable> {
}
