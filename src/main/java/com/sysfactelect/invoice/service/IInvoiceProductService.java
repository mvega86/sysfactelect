package com.sysfactelect.invoice.service;

import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface IInvoiceProductService {
    List<InvoiceProductDTO> findAll();
    InvoiceProductDTO findById(String type, Long serial, UUID id);
    List<InvoiceProductDTO> findByProduct(UUID id);
    List<InvoiceProductDTO> findByInvoice(String type, Long serial);
    void save(InvoiceProductDTO invoiceProductDTO);

}
