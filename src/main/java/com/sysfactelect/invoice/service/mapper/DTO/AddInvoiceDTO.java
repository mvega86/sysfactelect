package com.sysfactelect.invoice.service.mapper.DTO;

import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import com.sysfactelect.invoice.persistence.entity.InvoiceStatus;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddInvoiceDTO {
    private	String type;
    private	Long serial;
    private Commercial commercial;
    private	String description;
    private BigDecimal subtotal;
    private	BigDecimal discount;
    private	BigDecimal surcharge;
    private	BigDecimal total;
    private	String currency;
    private List<InvoiceProduct> invoiceProductList = new ArrayList<>();

}
