package com.sysfactelect.invoice.service.mapper.DTO;

import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
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
public class AddProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
}
