package com.example.website.mapper;

import com.example.website.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryMapper {

    /**
     * 根据id查询产品类别信息
     * @param id 产品类别id
     * @return 产品类别信息
     */
    ProductCategory findById(String id);

    /**
     * 获取所有的产品类别信息
     * @return 产品类别列表
     */
    List<ProductCategory> findProductCategoryList();
}
