package com.gege.controller;


import com.gege.entity.User;
import com.gege.mapper.UserMapper;
import com.gege.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-08-26
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        String username = user.getUsername();
        User user1 = userService.selectByUsername(username);
        if (user1==null){
            //不存在该用户名，可以注册
            boolean isAdd = userService.add(user);
            if (isAdd){
                return new Result(Code.SAVE_OK,"注册成功，请登录");
            }else {
                return new Result(Code.SAVE_ERR,"注册失败，服务器繁忙，请稍后再试");
            }

        }else {
            //用户名已存在
            return new Result(Code.USERNAME_ALREADY_EXISTS,"用户名已存在");
        }

    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User user1 = userService.select(user);
        if (user1!=null){
//            登陆成功
            return new Result(Code.LOGIN_SUCCESS, "登录成功");
        }
        else {
            return new Result(Code.LOGIN_Failure,"用户名或密码错误");
        }
    }



}

