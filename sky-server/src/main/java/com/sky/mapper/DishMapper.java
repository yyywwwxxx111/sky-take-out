package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);



    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);
    //菜品分页查询
    Page<DishDTO> queryPage(DishPageQueryDTO dishPageQueryDTO);

    //根据主键查询菜品
    @Select("select * from dish where id = #{id}")
    Dish getById(Long id);
    //根据主键删除dish
    @Delete("delete from dish where id = #{id}")
    void deleteByID(Long id);

    //批量删除菜品
    void deleteByIds(List<Long> ids);
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);
}
