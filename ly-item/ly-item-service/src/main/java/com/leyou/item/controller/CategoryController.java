package com.leyou.item.controller;

import com.leyou.pojo.Category;
import com.leyou.item.service.CategoryService;
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
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryByParentId(@RequestParam(value = "pid",defaultValue = "0")Long pid ){
        List<Category> categoryList=  categoryService.queryByParentId(pid);
        // 对categoryList 判断
        if (!categoryList.isEmpty()) {
            return ResponseEntity.ok(categoryList);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
