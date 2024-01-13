package com.sysfactelect.invoice.persistence.entity;

import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoices")
public class Invoice {

    @EmbeddedId
    private InvoiceId id;
    private Timestamp date;
    private String description;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal surcharge;
    private BigDecimal total;
    private String currency;
    private Boolean cancelled;
    @ManyToOne
    @JoinColumn(name = "id_commercial")
    private Commercial comercial;
}
