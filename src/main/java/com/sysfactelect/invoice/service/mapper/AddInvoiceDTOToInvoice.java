package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.InvoiceStatus;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.service.mapper.DTO.AddInvoiceDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddProductDTO;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AddInvoiceDTOToInvoice implements IMapper<AddInvoiceDTO, Invoice> {
    @Override
    public Invoice map(AddInvoiceDTO in) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(new InvoiceId(in.getType(),in.getSerial()));
        invoice.setDate(Timestamp.valueOf(LocalDateTime.now()));
        invoice.setDescription(in.getDescription());
        invoice.setTotal(in.getTotal());
        invoice.setDiscount(in.getDiscount());
        invoice.setSurcharge(in.getSurcharge());
        invoice.setSubtotal(in.getSubtotal());
        invoice.setCommercial(in.getCommercial());
        invoice.setCurrency(in.getCurrency());
        invoice.setStatus(InvoiceStatus.Finished);
        invoice.setInvoiceProductList(in.getInvoiceProductList());
        return invoice;
    }
}
