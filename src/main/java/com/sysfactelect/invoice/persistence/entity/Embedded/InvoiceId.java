package com.sysfactelect.invoice.persistence.entity.Embedded;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceId implements Serializable {
    private String type;
    private Long serial;
}
