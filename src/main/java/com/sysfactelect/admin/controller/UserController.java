package com.sysfactelect.admin.controller;

import com.sysfactelect.admin.service.IUserService;
import com.sysfactelect.admin.service.mapper.DTO.AddUserDTO;
import com.sysfactelect.admin.service.mapper.DTO.UserDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable UUID id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AddUserDTO addUserDTO){
        if (addUserDTO.getUsername().isBlank() || addUserDTO.getEmail().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        userService.save(addUserDTO);
        return ResponseEntity.created(URI.create("/admin/user/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody AddUserDTO addUserDTO){
        userService.update(id,addUserDTO);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted");

    }
}
