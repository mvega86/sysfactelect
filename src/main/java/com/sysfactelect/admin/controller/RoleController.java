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
@RequestMapping("/admin/roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<RoleDTO> roleDTOList = roleService.findAll();
        return ResponseEntity.ok(roleDTOList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        RoleDTO roleDTO = roleService.findById(id);
        return ResponseEntity.ok(roleDTO);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(AddRoleDTO roleDTO){
        if(roleDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        roleService.save(roleDTO);
        return ResponseEntity.created(URI.create("/admin/role/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, AddRoleDTO addRoleDTO){
        roleService.update(id, addRoleDTO);
        return ResponseEntity.ok("Role updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
            roleService.deleteById(id);
            return ResponseEntity.ok("Role eliminated");
    }
}
