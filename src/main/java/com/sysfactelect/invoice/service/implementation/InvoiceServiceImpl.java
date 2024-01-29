package com.sysfactelect.invoice.service.implementation;

import com.sysfactelect.exceptions.SysFactElectException;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.persistence.repository.InvoiceProductRepository;
import com.sysfactelect.invoice.persistence.repository.InvoiceRepository;
import com.sysfactelect.invoice.persistence.repository.ProductRepository;
import com.sysfactelect.invoice.service.IInvoiceService;
import com.sysfactelect.invoice.service.IProductService;
import com.sysfactelect.invoice.service.mapper.*;
import com.sysfactelect.invoice.service.mapper.DTO.*;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceProductRepository invoiceProductRepository;
    @Autowired
    private InvoiceProductDTOToInvoiceProduct invoiceProductDTOToInvoiceProduct;
    @Autowired
    private AddInvoiceDTOToInvoice addInvoiceDTOToInvoice;
    @Autowired
    private InvoiceToInvoiceDTO invoiceToInvoiceDTO;
    @Override
    public List<InvoiceDTO> findAll() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoice -> invoiceToInvoiceDTO.map(invoice))
                .toList();
    }

    @Override
    public InvoiceDTO findById(String type, Long serial) {
        InvoiceId invoiceId = new InvoiceId(type,serial);
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoiceId);
        if(optionalInvoice.isPresent()){
            return invoiceToInvoiceDTO.map(optionalInvoice.get());
        }
        throw new SysFactElectException("Invoice not found", HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public void save(AddInvoiceDTO invoiceDTO, List<InvoiceProductDTO> invoiceProductDTOList) {
        invoiceRepository.save(addInvoiceDTOToInvoice.map(invoiceDTO));
        for (InvoiceProductDTO invoiceProductDTO : invoiceProductDTOList) {
            invoiceProductRepository.save(invoiceProductDTOToInvoiceProduct.map(invoiceProductDTO));
        }
    }

    @Override
    public void cancelById(String type, Long serial) {
        InvoiceId invoiceId = new InvoiceId(type, serial);
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
        if(invoiceOptional.isPresent()){
            invoiceRepository.setCancelInvoice(type, serial);
        }
        throw new SysFactElectException("Invoice not found", HttpStatus.NOT_FOUND);
    }

}
