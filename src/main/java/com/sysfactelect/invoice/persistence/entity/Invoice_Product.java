package com.sysfactelect.invoice.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices_products", schema = "invoice")
public class Invoice_Product {
    @Id
    @ManyToOne
    private Invoice invoice;
    @Id
    @ManyToOne
    private Product product;
    private BigDecimal cant;
}
