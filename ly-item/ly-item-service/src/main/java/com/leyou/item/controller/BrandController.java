package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.service.BrandService;
import com.leyou.item.service.CategoryService;
import com.leyou.pojo.Brand;
import com.leyou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther SyntacticSugar
 * @data 2018/12/3 0003下午 3:55
 */
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
            @RequestParam(value = "key", required = false) String key
    ){

        PageResult<Brand> result=  brandService.queryBrandByPage(page,rows,sortBy,desc,key);
        // 判断result ，进行返回
        if (result==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok(result);
    }

}
