package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.service.mapper.DTO.AddProductDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddProductDTOToProduct implements IMapper<AddProductDTO, Product> {
    @Override
    public Product map(AddProductDTO in) {
        Product producto = new Product();
        producto.setId(UUID.randomUUID());
        producto.setName(in.getName());
        producto.setDescription(in.getDescription());
        producto.setPrice(in.getPrice());
        return producto;
    }
}
