package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.service.mapper.DTO.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDTO implements IMapper<Product, ProductDTO> {
    @Override
    public ProductDTO map(Product in) {
        return new ProductDTO(
                in.getId(),
                in.getName(),
                in.getDescription(),
                in.getPrice(),
                in.getInvoiceProductList()
        );
    }
}
