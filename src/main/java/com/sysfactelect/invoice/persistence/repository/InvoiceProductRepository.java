package com.sysfactelect.invoice.persistence.repository;

import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, InvoiceProductId> {

    @Query("select ip from InvoiceProduct ip where ip.id_product = ?1")
    List<InvoiceProduct> findByProduct(UUID id);
    @Query("select ip from InvoiceProduct ip where ip.type_invoice = ?1 and ip.serial_invoice = ?2")
    List<InvoiceProduct> findByInvoice(String type, Long id);
}
