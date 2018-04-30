package com.tzg.xhd.tbooking.service;

import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.common.BaseService;
import com.tzg.xhd.tbooking.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends BaseService<User>{
    /**
     * 保存用户信息
     * @param user
     * @return
     * @throws Exception
     */
    Answer saveUser(User user) throws Exception;

    /**
     * 根据用户名查找用户
     * @param loginName
     * @return
     */
    Answer<User> findUser(String loginName);
}
