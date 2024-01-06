package com.sysfactelect.admin.controller;

import com.sysfactelect.admin.service.mapper.DTO.AddRoleDTO;
import com.sysfactelect.admin.service.mapper.DTO.RoleDTO;
import com.sysfactelect.admin.service.IRoleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<RoleDTO> roleDTOList = roleService.findAll();
        return ResponseEntity.ok(roleDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        try {
            RoleDTO roleDTO = roleService.findById(id);
            return ResponseEntity.ok(roleDTO);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(AddRoleDTO roleDTO){
        if(roleDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        roleService.save(roleDTO);
        return ResponseEntity.created(URI.create("/role/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, AddRoleDTO addRoleDTO){
        try{
            RoleDTO getRoleDTO = roleService.findById(id);
            roleService.update(getRoleDTO, addRoleDTO);
            return ResponseEntity.ok("Role updated");
        }catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try {
            RoleDTO roleDTO = roleService.findById(id);
            roleService.deleteById(id);
            return ResponseEntity.ok("Role eliminated");
        }catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
