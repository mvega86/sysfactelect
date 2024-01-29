package com.sysfactelect.admin.controller;

import com.sysfactelect.admin.service.mapper.CompanyDTOToCompany;
import com.sysfactelect.admin.service.mapper.CompanyToCompanyDTO;
import com.sysfactelect.admin.service.mapper.DTO.AddCompanyDTO;
import com.sysfactelect.admin.service.mapper.DTO.CompanyDTO;
import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.service.ICompanyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(this.companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        CompanyDTO companyDTO = companyService.findById(id);
        return ResponseEntity.ok(companyDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AddCompanyDTO addCompanyDTO){
        if(addCompanyDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        companyService.save(addCompanyDTO);
        return ResponseEntity.created(URI.create("/company/save")).build();

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody AddCompanyDTO addCompanyDTO){
        companyService.update(id, addCompanyDTO);
        return ResponseEntity.ok("Company updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        companyService.deleteById(id);
        return ResponseEntity.ok("Company eliminated");
    }
}
