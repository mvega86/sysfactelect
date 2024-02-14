package com.sysfactelect.auth.service.mapper.dto;

import com.sysfactelect.admin.persistence.entity.Company;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    String username;
    String password;
    String email;
    String name;
    String lastname;
    Company company;
}
