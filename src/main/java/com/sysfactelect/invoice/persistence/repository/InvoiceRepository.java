package com.sysfactelect.invoice.persistence.repository;

import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceId;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import com.sysfactelect.invoice.persistence.entity.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, InvoiceId> {
    @Modifying
    @Query(value = "UPDATE INVOICES SET status = 'Cancelled' WHERE type =: type and serial =: serial", nativeQuery = true)
    void setCancelInvoice(String type, Long serial);

}
