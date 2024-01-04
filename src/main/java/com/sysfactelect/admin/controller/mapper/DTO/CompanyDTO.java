package com.sysfactelect.admin.controller.mapper.DTO;

import com.sysfactelect.admin.persistence.entity.User;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDTO {
    private Long id;
    private String name;
    private String acronym;
    private List<User> userList;
}
