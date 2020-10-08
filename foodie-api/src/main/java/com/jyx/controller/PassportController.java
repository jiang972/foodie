package com.jyx.controller;

import com.jyx.pojo.Users;
import com.jyx.pojo.bo.UserBO;
import com.jyx.service.UserService;
import com.jyx.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("passport")
@Api(value = "注册登录",tags = {"用于登录注册的接口"})//swagger配置
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在",notes = "用户名是否存在",httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username){
        if (StringUtils.isBlank(username)) return JSONResult.errorMsg("用户名不能为空");
        Boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist)return JSONResult.errorMsg("用户名已存在");
        return JSONResult.ok();
    }

    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    @PostMapping("/register")
    public JSONResult register(@RequestBody UserBO userBO){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String comfirmPwd = userBO.getConfirmPassword();
        //校验
        if (StringUtils.isBlank(password)||
                StringUtils.isBlank(username)||
                StringUtils.isBlank(comfirmPwd)){
            return JSONResult.errorMsg("data不能为null");
        }
        //用户名是否存在？
        Boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist)return JSONResult.errorMsg("用户名已存在");
        if (!password.equals(comfirmPwd)){
            return JSONResult.errorMsg("两次密码不一样");
        }
        Users user = userService.createUser(userBO);
        return JSONResult.ok(user);
    }
}

