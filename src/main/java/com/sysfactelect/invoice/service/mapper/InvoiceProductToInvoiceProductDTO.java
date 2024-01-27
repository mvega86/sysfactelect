package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceProductDTO;
import org.springframework.stereotype.Component;

@Component
public class InvoiceProductToInvoiceProductDTO implements IMapper<InvoiceProduct, InvoiceProductDTO> {
    @Override
    public InvoiceProductDTO map(InvoiceProduct in) {
        return new InvoiceProductDTO(
                in.getInvoiceProductId(),
                in.getInvoice(),
                in.getProduct(),
                in.getCant()
        );
    }
}
