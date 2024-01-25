package com.sysfactelect.invoice.service.mapper.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<InvoiceProduct> invoiceProductList = new ArrayList<>();
}
