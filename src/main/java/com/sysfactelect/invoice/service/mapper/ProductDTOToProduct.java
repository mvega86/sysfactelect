package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.service.mapper.DTO.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOToProduct implements IMapper<ProductDTO, Product> {
    @Override
    public Product map(ProductDTO in) {
        return new Product(
                in.getId(),
                in.getName(),
                in.getDescription(),
                in.getPrice(),
                in.getInvoiceProductList()
        );
    }
}
