package com.omratas.easynotes.controller;

import com.omratas.easynotes.model.Role;
import com.omratas.easynotes.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }
}
