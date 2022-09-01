package com.gege.mapper;

import com.gege.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-08-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
