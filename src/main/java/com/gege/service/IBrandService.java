package com.gege.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gege.entity.Brand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2022-08-26
 */
public interface IBrandService {
    List<Brand> getAll();
    boolean add(Brand brand);

    boolean update(Brand brand);

    boolean delete(int id);

    boolean deleteByIds(int [] ids);

    IPage selectPage(int current, int size);

    IPage selectPageByCondition(int current, int size, Brand brand);

}
