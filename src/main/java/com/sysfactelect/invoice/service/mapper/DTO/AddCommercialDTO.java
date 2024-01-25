package com.sysfactelect.invoice.service.mapper.DTO;

import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.invoice.persistence.entity.Invoice;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCommercialDTO {
    private String name;
    private String last_name;
    private String email;
    private User user;
}
