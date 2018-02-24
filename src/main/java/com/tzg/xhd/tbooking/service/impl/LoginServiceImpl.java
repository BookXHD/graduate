package com.tzg.xhd.tbooking.service.impl;

import com.github.abel533.mapper.Mapper;
import com.tzg.xhd.tbooking.common.Answer;
import com.tzg.xhd.tbooking.entity.Login;
import com.tzg.xhd.tbooking.mapper.LoginMapper;
import com.tzg.xhd.tbooking.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {
    private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    LoginMapper loginMapper;

    @Override
    public void save(Login login) {
        login.setDtCreate(new Date());
        login.setDtModify(new Date());
        loginMapper.insertSelective(login);
    }

    @Override
    public Answer<Login> findUser(String loginName) {
        Login login = null;
        Answer<Login> answer = new Answer<Login>();
        try{
            login = loginMapper.findUser(loginName);
            if(login == null){
                answer.setSuccess(false);
                answer.setMessage("用户名不存在！");
            }else {
                answer.setData(login);
            }
        }catch (Exception e){
            log.error("",e);
            answer.setMessage(e.getMessage());
            answer.setSuccess(false);
        }
        return answer;
    }
}
