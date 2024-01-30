package com.sysfactelect.invoice.controller;

import com.sysfactelect.invoice.service.IProductService;
import com.sysfactelect.invoice.service.mapper.DTO.AddProductDTO;
import com.sysfactelect.invoice.service.mapper.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AddProductDTO productDTO){
        if(productDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        productService.save(productDTO);
        return ResponseEntity.created(URI.create("/products/save")).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody AddProductDTO productDTO){
        productService.update(id, productDTO);
        return ResponseEntity.ok("Products updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted");
    }
}
