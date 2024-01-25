package com.sysfactelect.invoice.service;

import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.service.mapper.DTO.AddCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.CommercialDTO;

import java.util.List;
import java.util.UUID;

public interface ICommercialService {
    List<CommercialDTO> findAll();
    CommercialDTO findById(UUID id);
    void save(AddCommercialDTO commercialDTO);
    void deleteById(UUID id);
    void update(UUID id, AddCommercialDTO commercialDTO);
}
