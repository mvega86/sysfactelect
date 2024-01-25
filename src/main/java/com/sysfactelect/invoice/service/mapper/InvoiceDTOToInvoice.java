package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceDTO;
import com.sysfactelect.invoice.service.mapper.DTO.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class InvoiceDTOToInvoice implements IMapper<InvoiceDTO, Invoice> {
    @Override
    public Invoice map(InvoiceDTO in) {
        return new Invoice(
                new InvoiceId(in.getType(), in.getSerial()),
                in.getDate(),
                in.getCommercial(),
                in.getDescription(),
                in.getSubtotal(),
                in.getDiscount(),
                in.getSurcharge(),
                in.getTotal(),
                in.getCurrency(),
                in.getStatus(),
                in.getInvoiceProductList()
        );
    }
}
