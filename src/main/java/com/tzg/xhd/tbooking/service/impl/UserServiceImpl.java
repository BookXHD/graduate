package com.tzg.xhd.tbooking.service.impl;

import com.tzg.xhd.tbooking.common.*;
import com.tzg.xhd.tbooking.entity.User;
import com.tzg.xhd.tbooking.mapper.UserMapper;
import com.tzg.xhd.tbooking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service("userService")
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public Answer saveUser(User user) throws Exception {
        User user1 = null;
        Answer answer = new Answer();
        try {
            user1 = userMapper.findUser(user.getLoginName());
            if (null != user1) {
                answer = AnswerGenerator.genFailAnswer("用户名" + user.getLoginName() + "已存在！");
            } else {
                user.setDtCreate(new Date());
                user.setDtModify(new Date());
                userMapper.insertSelective(user);
                answer = AnswerGenerator.genSuccessAnswer("注册成功！");
            }
        }catch (Exception e) {
            answer = AnswerGenerator.genFailAnswer(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return answer;
    }

    @Override
    public Answer<User> findUser(String loginName) {
        User user = null;
        Answer<User> answer = new Answer<User>();
        user = userMapper.findUser(loginName);
        if(null != user){
            answer = AnswerGenerator.genSuccessAnswer(user);
        }else {
            answer = AnswerGenerator.genFailAnswer("用户名不存在！");
        }
        return answer;
    }
}
