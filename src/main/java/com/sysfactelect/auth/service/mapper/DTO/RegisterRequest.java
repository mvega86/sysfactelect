package com.sysfactelect.auth.service.mapper.DTO;

import com.sysfactelect.admin.persistence.entity.Company;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private Company company;

}
