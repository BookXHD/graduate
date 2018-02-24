package com.tzg.xhd.tbooking.mapper;

import com.tzg.xhd.tbooking.common.Mapper;
import com.tzg.xhd.tbooking.entity.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper extends Mapper<Login>{

    Login findUser(String loginName);
}
