package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2018/12/3 0003下午 3:52
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    //
    public List<Category> queryByParentId(Long pid) {
        Category category = new Category();
        //   根据 pid  查询
        category.setParentId(pid);
        return this.categoryMapper.select(category);
    }
}
