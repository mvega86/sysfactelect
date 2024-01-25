package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceDTO;
import org.springframework.stereotype.Component;

@Component
public class InvoiceToInvoiceDTO implements IMapper<Invoice, InvoiceDTO> {
    @Override
    public InvoiceDTO map(Invoice in) {
        return new InvoiceDTO(
                in.getInvoiceId().getType(),
                in.getInvoiceId().getSerial(),
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
