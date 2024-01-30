package com.sysfactelect.invoice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products", schema = "invoice")
public class Product {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @JsonManagedReference
    private List<InvoiceProduct> invoiceProductList = new ArrayList<>();
}
