package com.gege.service;

import com.gege.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-08-26
 */
public interface IUserService {

    User selectByUsername(String username);

    boolean add(User user);

    User select(User user);

}
