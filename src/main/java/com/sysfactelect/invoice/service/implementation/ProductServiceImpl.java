package com.sysfactelect.invoice.service.implementation;

import com.sysfactelect.exceptions.SysFactElectException;
import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.persistence.entity.Product;
import com.sysfactelect.invoice.persistence.repository.CommercialRepository;
import com.sysfactelect.invoice.persistence.repository.ProductRepository;
import com.sysfactelect.invoice.service.ICommercialService;
import com.sysfactelect.invoice.service.IProductService;
import com.sysfactelect.invoice.service.mapper.AddCommercialDTOToComercial;
import com.sysfactelect.invoice.service.mapper.AddProductDTOToProduct;
import com.sysfactelect.invoice.service.mapper.CommercialToCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddProductDTO;
import com.sysfactelect.invoice.service.mapper.DTO.CommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.ProductDTO;
import com.sysfactelect.invoice.service.mapper.ProductToProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AddProductDTOToProduct addProductDTOToProduct;
    @Autowired
    private ProductToProductDTO productToProductDTO;
    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> productToProductDTO.map(product))
                .toList();
    }

    @Override
    public ProductDTO findById(UUID id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return productToProductDTO.map(optionalProduct.get());
        }
        throw new SysFactElectException("Product not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public void save(AddProductDTO productDTO) {
        productRepository.save(addProductDTOToProduct.map(productDTO));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
        }
        throw new SysFactElectException("Product not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public void update(UUID id, AddProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setName(productDTO.getName());
        }
        throw new SysFactElectException("Product not found", HttpStatus.NOT_FOUND);
    }
}
