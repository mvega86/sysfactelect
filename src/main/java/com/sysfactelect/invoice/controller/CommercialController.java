package com.sysfactelect.invoice.controller;

import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.service.ICommercialService;
import com.sysfactelect.invoice.service.mapper.DTO.AddCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.CommercialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/commercials")
public class CommercialController {
    @Autowired
    private ICommercialService commercialService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(commercialService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        CommercialDTO commercialDTO = commercialService.findById(id);
        return ResponseEntity.ok(commercialDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AddCommercialDTO commercialDTO){
        if(commercialDTO.getName().isBlank() || commercialDTO.getEmail().isBlank() || commercialDTO.getUser().getUsername().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        commercialService.save(commercialDTO);
        return ResponseEntity.created(URI.create("/commercials/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody AddCommercialDTO commercialDTO){
        commercialService.update(id, commercialDTO);
        return ResponseEntity.ok("Commercial updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        commercialService.deleteById(id);
        return ResponseEntity.ok("Commercial deleted");
    }
}
