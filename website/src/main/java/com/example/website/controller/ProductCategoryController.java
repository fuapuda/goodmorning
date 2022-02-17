package com.example.website.controller;

import com.example.website.entity.ProductCategory;
import com.example.website.service.IProductCategoryService;
import com.example.website.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product_categorys")
public class ProductCategoryController {
    @Autowired
    IProductCategoryService productCategoryService;

    @RequestMapping("info")
    public R<ProductCategory> getProductCategoryInfo(String category){
        ProductCategory productCategory = productCategoryService.getProductCategoryInfo(category);
        System.out.println(productCategory);
        return R.ok(productCategory);
    }

    @RequestMapping("list")
    public R<List<ProductCategory>> getProductCategorylist() {
        return R.ok(productCategoryService.getProductCategoryList());
    }
}
