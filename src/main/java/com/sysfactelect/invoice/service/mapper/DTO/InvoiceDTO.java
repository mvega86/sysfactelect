package com.sysfactelect.invoice.service.mapper.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import com.sysfactelect.invoice.persistence.entity.InvoiceStatus;
import jakarta.persistence.*;
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
public class InvoiceDTO {
    private	String type;
    private	Long serial;
    private Timestamp date;
    private Commercial commercial;
    private	String description;
    private BigDecimal subtotal;
    private	BigDecimal discount;
    private	BigDecimal surcharge;
    private	BigDecimal total;
    private	String currency;
    private InvoiceStatus status;
    private List<InvoiceProduct> invoiceProductList = new ArrayList<>();

}
