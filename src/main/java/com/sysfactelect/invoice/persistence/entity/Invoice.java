package com.sysfactelect.invoice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices", schema = "invoice")
public class Invoice {
    @EmbeddedId
    private InvoiceId invoiceId;
    private Timestamp       date;
    @ManyToOne
    @JoinColumn(name = "id_commercial")
    @JsonIgnore
    private Commercial      commercial;
    private	String	        description;
    private BigDecimal      subtotal;
    private	BigDecimal	    discount;
    private	BigDecimal	    surcharge;
    private	BigDecimal	    total;
    private	String	        currency;
    @Enumerated(EnumType.STRING)
    private	InvoiceStatus   status;
    @OneToMany(mappedBy = "invoice")
    @JsonIgnore
    private List<InvoiceProduct> invoiceProductList = new ArrayList<>();
}
