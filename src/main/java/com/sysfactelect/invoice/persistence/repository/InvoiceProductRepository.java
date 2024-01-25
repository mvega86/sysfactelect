package com.sysfactelect.invoice.persistence.repository;

import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, InvoiceProductId> {
}
