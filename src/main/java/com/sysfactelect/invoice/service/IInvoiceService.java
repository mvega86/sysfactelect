package com.sysfactelect.invoice.service;

import com.sysfactelect.invoice.service.mapper.DTO.AddCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddInvoiceDTO;
import com.sysfactelect.invoice.service.mapper.DTO.CommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceDTO;

import java.util.List;
import java.util.UUID;

public interface IInvoiceService {
    List<InvoiceDTO> findAll();
    InvoiceDTO findById(String type, Long serial);
    void save(AddInvoiceDTO invoiceDTO);
    void deleteById(String type, Long serial);
}
