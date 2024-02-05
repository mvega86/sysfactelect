package com.sysfactelect.admin.service.mapper.DTO;

import com.sysfactelect.admin.persistence.entity.RoleName;
import com.sysfactelect.admin.persistence.entity.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleByUserDTO {
    private Long id;
    private RoleName name;

}
