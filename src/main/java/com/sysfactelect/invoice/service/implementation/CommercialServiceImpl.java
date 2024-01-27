package com.sysfactelect.invoice.service.implementation;

import com.sysfactelect.exceptions.SysFactElectException;
import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.persistence.repository.CommercialRepository;
import com.sysfactelect.invoice.service.ICommercialService;
import com.sysfactelect.invoice.service.mapper.AddCommercialDTOToComercial;
import com.sysfactelect.invoice.service.mapper.CommercialDTOToCommercial;
import com.sysfactelect.invoice.service.mapper.CommercialToCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.AddCommercialDTO;
import com.sysfactelect.invoice.service.mapper.DTO.CommercialDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommercialServiceImpl implements ICommercialService {
    @Autowired
    private CommercialRepository commercialRepository;
    @Autowired
    private AddCommercialDTOToComercial addCommercialDTOToComercial;
    @Autowired
    private CommercialToCommercialDTO commercialToCommercialDTO;
    @Override
    public List<CommercialDTO> findAll() {
        return commercialRepository.findAll()
                .stream()
                .map(commercial -> commercialToCommercialDTO.map(commercial))
                .toList();
    }

    @Override
    public CommercialDTO findById(UUID id) {
        Optional<Commercial> optionalCommercial = commercialRepository.findById(id);
        if(optionalCommercial.isPresent()){
            return commercialToCommercialDTO.map(optionalCommercial.get());
        }
        throw new SysFactElectException("Commercial not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public void save(AddCommercialDTO commercialDTO) {
        commercialRepository.save(addCommercialDTOToComercial.map(commercialDTO));
    }

    @Override
    public void deleteById(UUID id) {
        Optional<Commercial> optionalCommercial = commercialRepository.findById(id);
        if(optionalCommercial.isPresent()){
            commercialRepository.deleteById(id);
        }
        throw new SysFactElectException("Commercial not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public void update(UUID id, AddCommercialDTO commercialDTO) {
        Optional<Commercial> optionalCommercial = commercialRepository.findById(id);
        if(optionalCommercial.isPresent()){
            Commercial commercial = optionalCommercial.get();
            commercial.setUser(commercialDTO.getUser());
            commercial.setEmail(commercialDTO.getEmail());
            commercial.setName(commercialDTO.getName());
            commercial.setLast_name(commercialDTO.getLast_name());
        }
        throw new SysFactElectException("Commercial not found", HttpStatus.NOT_FOUND);
    }
}
