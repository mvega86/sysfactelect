package com.sysfactelect.invoice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices_products", schema = "invoice")
public class InvoiceProduct {

    @EmbeddedId
    private InvoiceProductId invoiceProductId;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="serial_invoice"),
            @JoinColumn(name="type_invoice")
    })
    @MapsId("invoiceId")
    @JsonIgnore
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name="id_product")
    @MapsId("id")
    @JsonIgnore
    private Product product;
    private BigDecimal cant;
}
