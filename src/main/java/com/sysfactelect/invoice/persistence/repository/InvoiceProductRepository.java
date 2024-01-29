package com.sysfactelect.invoice.persistence.repository;

import com.sysfactelect.invoice.persistence.entity.Embedded.InvoiceProductId;
import com.sysfactelect.invoice.persistence.entity.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, InvoiceProductId> {

    @Query(value = "select * from invoices_products where id_product =: id", nativeQuery = true)
    List<InvoiceProduct> findByProduct(UUID id);
    @Query(value = "select * from invoices_products where type_invoice =: type and serial_invoice =: serial", nativeQuery = true)
    List<InvoiceProduct> findByInvoice( String type, Long serial);
}
