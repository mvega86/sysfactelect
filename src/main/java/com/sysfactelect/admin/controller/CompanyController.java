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
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;
    @Autowired
    private CompanyDTOToCompany companyDTOToCompany;

    @Autowired
    private CompanyToCompanyDTO companyToCompanyDTO;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(this.companyService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        try{
            CompanyDTO companyDTO = companyService.findById(id);
            return ResponseEntity.ok(companyDTO);
        }catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
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
        try{
            CompanyDTO companyDTO = companyService.findById(id);
            if(addCompanyDTO.getName().isBlank()){
                return ResponseEntity.badRequest().build();
            }
            companyService.update(companyDTO, addCompanyDTO);
            return ResponseEntity.ok("Company updated");
        }catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        try{
            CompanyDTO companyDTO = companyService.findById(id);
            companyService.deleteById(id);
            return ResponseEntity.ok("Company eliminated");
        }catch(EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
