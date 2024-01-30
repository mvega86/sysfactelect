package com.sysfactelect.invoice.service;

import com.sysfactelect.invoice.service.mapper.DTO.*;

import java.util.List;
import java.util.UUID;

public interface IInvoiceService {
    List<InvoiceDTO> findAll();
    InvoiceDTO findById(String type, Long serial);
    void save(AddInvoiceDTO invoiceDTO, List<InvoiceProductDTO> invoiceProductDTOList);
    void setCancel(String type, Long serial);
    List<InvoiceProductDTO> findProductsByInvoiceId(String type, Long serial);
    InvoiceProductDTO findProductByIdInvoiceByProductId(String type, Long serial, UUID id);
}
