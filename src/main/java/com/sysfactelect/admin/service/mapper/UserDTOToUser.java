package com.sysfactelect.admin.service.mapper;

import com.sysfactelect.admin.persistence.entity.User;
import com.sysfactelect.admin.service.mapper.DTO.UserDTO;
import com.sysfactelect.imapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDTOToUser implements IMapper<UserDTO, User> {
    @Override
    public User map(UserDTO in) {
        return new User(
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
