package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.service.mapper.DTO.AddCommercialDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AddCommercialDTOToComercial implements IMapper<AddCommercialDTO, Commercial> {
    @Override
    public Commercial map(AddCommercialDTO in) {
        Commercial commercial = new Commercial();
        commercial.setId(UUID.randomUUID());
        commercial.setName(in.getName());
        commercial.setLast_name(in.getLast_name());
        commercial.setEmail(in.getEmail());
        commercial.setUser(in.getUser());
        return commercial;
    }
}
