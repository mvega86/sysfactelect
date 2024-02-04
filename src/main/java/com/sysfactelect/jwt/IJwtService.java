package com.sysfactelect.jwt;

import com.sysfactelect.admin.persistence.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String getToken(UserDetails user);
}
