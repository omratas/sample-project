package com.omratas.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.omratas.easynotes.listener.AuditingEntityListener;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "notes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Data
public class Note extends AbstractEntity implements Serializable {

    @NotBlank
    private String title;
    @NotBlank
    private String content;


}
