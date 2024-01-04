package com.sysfactelect.admin.controller;

import com.sysfactelect.admin.controller.mapper.CompanyDTOToCompany;
import com.sysfactelect.admin.controller.mapper.CompanyToCompanyDTO;
import com.sysfactelect.admin.controller.mapper.DTO.CompanyDTO;
import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        List<CompanyDTO> companiesDTO = this.companyService.findAll()
                .stream()
                .map(company -> companyToCompanyDTO.map(company))
                .toList();
        return ResponseEntity.ok(companiesDTO);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Company> optionalCompany = companyService.findById(id);
        if(optionalCompany.isPresent()){

            Company company = optionalCompany.get();
            CompanyDTO companyDTO = companyToCompanyDTO.map(company);
            return ResponseEntity.ok(companyDTO);

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CompanyDTO companyDTO){

        if(companyDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        companyService.save(companyDTOToCompany.map(companyDTO));
        return ResponseEntity.ok(companyDTO);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CompanyDTO companyDTO){
        Optional<Company> optionalCompany = companyService.findById(id);
        if(optionalCompany.isPresent()){
            if(companyDTO.getName().isBlank()){
                return ResponseEntity.badRequest().build();
            }
            companyService.save(companyDTOToCompany.map(companyDTO));
            return ResponseEntity.ok(companyDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Optional<Company> optionalCompany = companyService.findById(id);
        if(optionalCompany.isPresent()){
            List<CompanyDTO> companyDTOList = companyService.deleteById(id)
                    .stream()
                    .map(company -> companyToCompanyDTO.map(company))
                    .toList();
            return ResponseEntity.ok(companyDTOList);

        }

        return ResponseEntity.notFound().build();
    }
}
