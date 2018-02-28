package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.BaseService;
import com.tzg.xhd.tbooking.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends BaseService<User>{
    Answer saveUser(User user) throws Exception;

    Answer<User> findUser(String loginName);
}
