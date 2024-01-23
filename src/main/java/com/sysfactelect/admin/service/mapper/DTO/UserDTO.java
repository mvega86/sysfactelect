package com.sysfactelect.admin.service.mapper.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sysfactelect.admin.persistence.entity.Company;
import com.sysfactelect.admin.persistence.entity.Role;
import com.sysfactelect.invoice.persistence.entity.Commercial;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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
    private List<Role> roles = new ArrayList<>();
    private Commercial commercial;
}
