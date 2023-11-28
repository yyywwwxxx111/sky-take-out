package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {
    //新增菜品和对应口味
    public void saveWithFlavor(DishDTO dishDTO);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void deleteBatch(List<Long> ids);

    //根据id查询菜品
    DishVO getByIdWithFlavor(Long id);
    //修改菜品
    void updateWithFlavor(DishDTO dishDTO);
}
