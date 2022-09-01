package com.gege.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.gege.entity.Brand;
import com.gege.service.IBrandService;
import com.gege.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2022-08-26
 */
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;



    @GetMapping
    public Result getAll(){
        List<Brand> brands = brandService.getAll();
        if (brands == null) {
            return new Result(Code.GET_ERR,"服务器繁忙，请稍后再试");
        }
        else {
            return new Result(Code.GET_OK,brands);
        }
    }

    @PutMapping
    public Result update(@RequestBody Brand brand){
        boolean isUpdate = brandService.update(brand);
        if (isUpdate) {
            return new Result(Code.UPDATE_OK, "修改成功");

        }
        else {
            return new Result(Code.UPDATE_ERR, "修改失败，请检查字段");
        }
    }



    @PostMapping
    public Result add(@RequestBody Brand brand){
        boolean isAdd = brandService.add(brand);
        if(isAdd){
            return new Result(Code.SAVE_OK, "添加成功");
        }else {
            return new Result(Code.SAVE_ERR, "添加失败，请重试");
        }

    }

    @PostMapping("/{info}")
    public Result selectByCondition(@PathVariable int [] info, @RequestBody Brand brand){

        int current = info[0];
        int size = info[1];
        System.out.println(current+"   "+size);
        System.out.println(brand);
        IPage page =  brandService.selectPageByCondition(current, size, brand);
        if (page == null) {
            return new Result(Code.GET_ERR,"服务器繁忙，请稍后再试");
        }
        else {
            return new Result(Code.GET_OK,page);
        }

    }

    @DeleteMapping("/{ids}")
    public Result deleteWarehouseById(@PathVariable int[] ids){
        for (int id : ids) {
            System.out.println(id);
        }
        boolean isDelete = brandService.deleteByIds(ids);
        if (isDelete){
            return new Result(Code.DELETE_OK, "删除成功");
        }else {
            return new Result(Code.DELETE_ERR, "删除失败，请重试");
        }

    }

    @GetMapping("/{info}")
    public Result selectByPage(@PathVariable int [] info){
        int current = info[0];
        int size = info[1];
        IPage page = brandService.selectPage(current, size);
        if (page == null) {
            return new Result(Code.GET_ERR,"服务器繁忙，请稍后再试");
        }
        else {
            return new Result(Code.GET_OK,page);
        }
    }


}

