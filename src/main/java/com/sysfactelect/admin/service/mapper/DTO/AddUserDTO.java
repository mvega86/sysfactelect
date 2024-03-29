package com.sysfactelect.admin.service.mapper.DTO;

import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.persistence.entity.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserDTO {
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private Company company;
}
