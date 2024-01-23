package com.sysfactelect.invoice.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices", schema = "invoice")
public class Invoice {
    @Id
    private	String	        type;
    @Id
    private	Long	        serial;
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
    private List<Invoice_Product> invoiceProductList = new ArrayList<>();
}
