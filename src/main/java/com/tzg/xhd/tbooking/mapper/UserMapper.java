package com.tzg.xhd.tbooking.mapper;

import com.tzg.xhd.tbooking.common.Mapper;
import com.tzg.xhd.tbooking.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends Mapper<User>{

    User findUser(String loginName);
}
