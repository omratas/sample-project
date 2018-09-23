package com.omratas.easynotes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "app_role")
@Data
public class Role extends AbstractEntity implements Serializable {

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "description")
    private String description;

}
