package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.admin.service.mapper.DTO.UserDTO;
import com.sysfactelect.imapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTO implements IMapper<User, UserDTO> {
    @Override
    public UserDTO map(User in) {
        return new UserDTO(
                in.getId(),
                in.getUsername(),
                in.getPassword(),
                in.getEmail(),
                in.getName(),
                in.getLastname(),
                in.getCompany(),
                in.getRoles(),
                in.getCommercial()
        );
    }
}
