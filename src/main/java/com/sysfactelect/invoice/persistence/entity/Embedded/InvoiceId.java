package com.sysfactelect.invoice.persistence.entity.Embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceId implements Serializable {
    private	String	        type;
    private	Long	        serial;
}
