package com.sysfactelect.admin.service.mapper.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.admin.persistence.entity.Company;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastname;
    private Company company;
}
