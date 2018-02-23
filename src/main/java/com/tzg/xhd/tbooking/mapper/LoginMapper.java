package com.tzg.xhd.tbooking.mapper;

import com.tzg.xhd.tbooking.entity.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    void save(Login login);

    Login findUser(String loginName);
}
