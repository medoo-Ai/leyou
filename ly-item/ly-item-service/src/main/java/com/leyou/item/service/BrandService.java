package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.pojo.Brand;
import com.leyou.pojo.Category;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2018/12/3 0003下午 3:52
 */
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    /**
     *    分页查询 brand 、需完成分页、排序、查询
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy,
                                              Boolean desc, String key) {
        // 分页查询
        PageHelper.startPage(page,rows);
        //排序
        Example example = new Example(Brand.class);
        /*
        排序判断是否需排序、
            设置查询条件/需对查询条件进行判断是否为空、
            查询
        */
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy+(desc?"desc":"asc"));
        }

        if (StringUtils.isNotBlank(key)) {
        example.createCriteria().andLike("name", key).orEqualTo("letter", key.toUpperCase());
        }
        //查询
        List<Brand> brandList = this.brandMapper.selectByExample(example);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        //返回总条数total， List<T> items 可以算出页数
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }
}
