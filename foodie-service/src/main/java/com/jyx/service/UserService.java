package com.jyx.service;

import com.jyx.pojo.Users;
import com.jyx.pojo.bo.UserBO;

public interface UserService {

    /**
     * 判断用户名是否已经存在
     * @param username
     * @return
     */
    Boolean queryUsernameIsExist(String username);

    /**
     * 创建user
     * @return
     */
    Users createUser(UserBO userBO);
}
