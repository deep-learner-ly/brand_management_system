package com.gege.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gege.entity.Brand;
import com.gege.mapper.BrandMapper;
import com.gege.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-08-26
 */
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;



    @Override
    public List<Brand> getAll() {
        List<Brand> brands = brandMapper.selectList(null);
        return brands;
    }

    @Override
    public boolean add(Brand brand) {
        int num = brandMapper.insert(brand);
        return num>0;
    }

    @Override
    public boolean update(Brand brand) {
        int num = brandMapper.updateById(brand);
        return num>0;


    }

    @Override
    public boolean delete(int id) {
        int num = brandMapper.deleteById(id);
        return num>0;

    }

    @Override
    public boolean deleteByIds(int[] ids) {
        int num = brandMapper.deleteByIds(ids);
        System.out.println("删除数量：" + num);
        return num>0;
    }

    @Override
    public IPage selectPage(int current, int size) {
        IPage page = new Page();
        page.setCurrent(current);
        page.setSize(size);
        brandMapper.selectPage(page, null);
        return page;
    }

    @Override
    public IPage selectPageByCondition(int current, int size, Brand brand) {
        IPage page = new Page();
        page.setCurrent(current);
        page.setSize(size);
        LambdaQueryWrapper<Brand> queryWrapper = new LambdaQueryWrapper<>();
        if (brand.getBrandName()!=null&& !brand.getBrandName().equals("")){
            queryWrapper.like(Brand::getBrandName,brand.getBrandName());
        }
        if (brand.getCompanyName()!=null&& !brand.getCompanyName().equals("")){
            queryWrapper.like(Brand::getCompanyName,brand.getCompanyName());
        }
        if (brand.getStatus()!=null){
            queryWrapper.like(Brand::getStatus,brand.getStatus());
        }
        brandMapper.selectPage(page, queryWrapper);
        return page;
    }
}
