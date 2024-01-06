package com.sysfactelect.admin.service.mapper.DTO;

import com.sysfactelect.admin.persistence.entity.User;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {
    private UUID id;
    private String name;
    private String acronym;
    private List<User> userList;
}
