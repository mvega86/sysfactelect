package com.sysfactelect.invoice.persistence.entity.Embedded;

import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class InvoiceProductId implements Serializable {
    private InvoiceId invoiceId;
    private UUID id;
}
