package com.sysfactelect.invoice.service.mapper;

import com.sysfactelect.imapper.IMapper;
import com.sysfactelect.invoice.persistence.entity.Commercial;
import com.sysfactelect.invoice.service.mapper.DTO.CommercialDTO;
import org.springframework.stereotype.Component;

@Component
public class CommercialDTOToCommercial implements IMapper<CommercialDTO, Commercial> {
    @Override
    public Commercial map(CommercialDTO in) {
        return new Commercial(
                in.getId(),
                in.getName(),
                in.getLast_name(),
                in.getEmail(),
                in.getUser(),
                in.getInvoiceList()
        );
    }
}
