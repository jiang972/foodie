package com.jyx.service.impl;

import com.jyx.enums.Sex;
import com.jyx.mapper.UsersMapper;
import com.jyx.pojo.Users;
import com.jyx.pojo.bo.UserBO;
import com.jyx.service.UserService;
import com.jyx.utils.DateUtil;
import com.jyx.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    public static final String USER_FACE = "/home/data/111.png";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andEqualTo("username",username);
        Users users = usersMapper.selectOneByExample(userExample);
        return users == null ? false:true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBO) {
        String userId = sid.nextShort();
        Users users = new Users();
        users.setId(userId);
        users.setUsername(userBO.getUsername());
        try {
            users.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //昵称
        users.setNickname(userBO.getUsername());
        //默认头像
        users.setFace(USER_FACE);
        //默认生日
        users.setBirthday(DateUtil.stringToDate("1970-01-01"));
        //性别
        users.setSex(Sex.secret.type);
        users.setCreatedTime(new Date());
        users.setUpdatedTime(new Date());
        usersMapper.insert(users);
        return users;
    }
}
