package com.sysfactelect.invoice.service.implementation;

import com.sysfactelect.exceptions.SysFactElectException;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import com.sysfactelect.invoice.persistence.repository.InvoiceProductRepository;
import com.sysfactelect.invoice.service.IInvoiceProductService;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceProductDTO;
import com.sysfactelect.invoice.service.mapper.InvoiceProductDTOToInvoiceProduct;
import com.sysfactelect.invoice.service.mapper.InvoiceProductToInvoiceProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceProductServiceImpl implements IInvoiceProductService {
    @Autowired
    private InvoiceProductRepository invoiceProductRepository;
    @Autowired
    private InvoiceProductToInvoiceProductDTO invoiceProductToInvoiceProductDTO;
    @Autowired
    private InvoiceProductDTOToInvoiceProduct invoiceProductDTOToInvoiceProduct;
    @Override
    public List<InvoiceProductDTO> findAll() {
        return invoiceProductRepository.findAll()
                .stream()
                .map(invoiceProduct -> invoiceProductToInvoiceProductDTO.map(invoiceProduct))
                .toList();
    }

    @Override
    public InvoiceProductDTO findById(String type, Long serial, UUID id) {
        InvoiceId invoiceId = new InvoiceId(type, serial);
        InvoiceProductId invoiceProductId = new InvoiceProductId(invoiceId,id);
        Optional<InvoiceProduct> optionalInvoiceProduct = invoiceProductRepository.findById(invoiceProductId);
        if(optionalInvoiceProduct.isPresent()) {
            return invoiceProductToInvoiceProductDTO.map(optionalInvoiceProduct.get());
        }
        throw new SysFactElectException("Product with that invoice not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<InvoiceProductDTO> findByProduct(UUID id) {
        return invoiceProductRepository.findByProduct(id)
                .stream()
                .map(invoiceProduct -> invoiceProductToInvoiceProductDTO.map(invoiceProduct))
                .toList();
    }

    @Override
    public List<InvoiceProductDTO> findByInvoice(String type, Long serial) {
        return invoiceProductRepository.findByInvoice(type, serial)
                .stream()
                .map(invoiceProduct -> invoiceProductToInvoiceProductDTO.map(invoiceProduct))
                .toList();
    }

    @Override
    public void save(InvoiceProductDTO invoiceProductDTO) {
        invoiceProductRepository.save(invoiceProductDTOToInvoiceProduct.map(invoiceProductDTO));
    }
}
