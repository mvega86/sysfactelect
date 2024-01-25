package com.sysfactelect.invoice.service;

import com.sysfactelect.invoice.service.mapper.DTO.AddCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddProductDTO;
import com.sysfactelect.invoice.service.mapper.DTO.CommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(UUID id);
    void save(AddProductDTO productDTO);
    void deleteById(UUID id);
    void update(UUID id, AddProductDTO productDTO);
}
