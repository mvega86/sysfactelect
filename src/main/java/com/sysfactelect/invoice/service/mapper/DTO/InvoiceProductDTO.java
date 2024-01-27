package com.sysfactelect.invoice.service.mapper.DTO;

import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.Product;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceProductDTO {
    private InvoiceProductId invoiceProductId;
    private Invoice invoice;
    private Product product;
    private BigDecimal cant;
}
