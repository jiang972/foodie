package com.jyx.controller;

import com.jyx.pojo.Users;
import com.jyx.pojo.bo.UserBO;
import com.jyx.service.UserService;
import com.jyx.utils.CookieUtils;
import com.jyx.utils.JSONResult;
import com.jyx.utils.JsonUtils;
import com.jyx.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO,
                             HttpServletRequest request, HttpServletResponse response){
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
        user = setNullProperty(user);
        //设置cookie,isEncode是是否加密
        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(user),true);
        return JSONResult.ok(user);
    }

    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public JSONResult login(@RequestBody UserBO userBO,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        //校验
        if (StringUtils.isBlank(password)||
                StringUtils.isBlank(username)){
            return JSONResult.errorMsg("data不能为null");
        }
        Users user = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if (user == null){
            return JSONResult.errorMsg("用户名或者密码不正确");
        }
        user = setNullProperty(user);
        //设置cookie,isEncode是是否加密
        CookieUtils.setCookie(request,response,"user",
                JsonUtils.objectToJson(user),true);
        return JSONResult.ok(user);
    }

    @ApiOperation(value = "用户退出登录",notes = "用户退出登录",httpMethod = "POST")
    @PostMapping("/logout")
    public JSONResult logout(@RequestBody String userId,
                             HttpServletRequest request, HttpServletResponse response)  {

        //设置cookie,isEncode是是否加密
        CookieUtils.deleteCookie(request,response,"user");
        return JSONResult.ok();
    }




    private Users setNullProperty(Users users){
        users.setPassword(null);
        users.setCreatedTime(null);
        users.setMobile(null);
        users.setEmail(null);
        users.setBirthday(null);
        users.setUpdatedTime(null);
        return users;
    }
}

