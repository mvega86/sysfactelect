package com.sysfactelect.invoice.persistence.entity.Embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;

@Embeddable
public class InvoiceId implements Serializable {
    private	String	        type;
    private	Long	        serial;
}
