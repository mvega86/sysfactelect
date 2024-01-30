package com.sysfactelect.invoice.controller;

import com.sysfactelect.invoice.service.IInvoiceService;
import com.sysfactelect.invoice.service.mapper.DTO.AddInvoiceDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddProductDTO;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private IInvoiceService invoiceService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(invoiceService.findAll());
    }
    @GetMapping("/{type}/{serial}")
    public ResponseEntity<?> findById(@PathVariable String type, @PathVariable Long serial){
        return ResponseEntity.ok(invoiceService.findById(type, serial));
    }
    @GetMapping("/{type}/{serial}/products")
    public ResponseEntity<?> findByIdInvoiceProducts(@PathVariable String type, @PathVariable Long serial){
        return ResponseEntity.ok(invoiceService.findProductsByInvoiceId(type, serial));
    }
    @GetMapping("/{type}/{serial}/product/{id}")
    public ResponseEntity<?> findByIdInvoiceByIdProduct(@PathVariable String type, @PathVariable Long serial, @PathVariable UUID id){
        return ResponseEntity.ok(invoiceService.findProductByIdInvoiceByProductId(type, serial, id));
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AddInvoiceDTO invoiceDTO, @RequestBody List<InvoiceProductDTO> invoiceProductDTOList){
        if(invoiceDTO.getType().isBlank() ||
                invoiceDTO.getSerial() == null ||
                invoiceDTO.getCommercial() == null ||
                invoiceDTO.getCurrency().isBlank() ||
                invoiceDTO.getTotal().compareTo(BigDecimal.valueOf(0)) <= 0){
            return ResponseEntity.badRequest().build();
        }
        invoiceService.save(invoiceDTO, invoiceProductDTOList);
        return ResponseEntity.created(URI.create("/invoices/save")).build();
    }
    @PatchMapping("/cancel/{type}/{serial}")
    public ResponseEntity<?> cancel(@PathVariable String type, @PathVariable Long serial){
        invoiceService.setCancel(type, serial);
        return ResponseEntity.ok("Invoice cancelled");
    }
}
