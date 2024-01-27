package com.sysfactelect.invoice.service.implementation;

import com.sysfactelect.exceptions.SysFactElectException;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.persistence.repository.InvoiceRepository;
import com.sysfactelect.invoice.persistence.repository.ProductRepository;
import com.sysfactelect.invoice.service.IInvoiceService;
import com.sysfactelect.invoice.service.IProductService;
import com.sysfactelect.invoice.service.mapper.AddInvoiceDTOToInvoice;
import com.sysfactelect.invoice.service.mapper.AddProductDTOToProduct;
import com.sysfactelect.invoice.service.mapper.DTO.AddInvoiceDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddProductDTO;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceDTO;
import com.sysfactelect.invoice.service.mapper.DTO.ProductDTO;
import com.sysfactelect.invoice.service.mapper.InvoiceToInvoiceDTO;
import com.sysfactelect.invoice.service.mapper.ProductToProductDTO;
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
    public void save(AddInvoiceDTO invoiceDTO) {
        invoiceRepository.save(addInvoiceDTOToInvoice.map(invoiceDTO));
    }

    @Override
    public void deleteById(String type, Long serial) {
        InvoiceId invoiceId = new InvoiceId(type, serial);
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoiceId);
        if(invoiceOptional.isPresent()){
            invoiceRepository.deleteById(invoiceId);
        }
        throw new SysFactElectException("Invoice not found", HttpStatus.NOT_FOUND);
    }

}
