package com.example.website.service;

import com.example.website.entity.ProductCategory;

import java.util.List;

public interface IProductCategoryService {

    /**
     * 获取id对应的产品类别信息
     * @param id 产品类别id
     * @return 产品类别信息
     */
    ProductCategory getProductCategoryInfo(String id);

    /**
     * 获取所有的产品类别信息
     * @return 产品类别信息列表
     */
    List<ProductCategory> getProductCategoryList();
}
