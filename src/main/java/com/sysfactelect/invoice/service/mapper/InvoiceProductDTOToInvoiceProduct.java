package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import com.sysfactelect.invoice.service.mapper.DTO.InvoiceProductDTO;
import org.springframework.stereotype.Component;

@Component
public class InvoiceProductDTOToInvoiceProduct implements IMapper<InvoiceProductDTO, InvoiceProduct> {
    @Override
    public InvoiceProduct map(InvoiceProductDTO in) {
        return new InvoiceProduct(
                in.getInvoiceProductId(),
                in.getInvoice(),
                in.getProduct(),
                in.getCant()
        );
    }
}
