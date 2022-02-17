package com.example.website.service.impl;

import com.example.website.entity.ProductCategory;
import com.example.website.mapper.ProductCategoryMapper;
import com.example.website.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;


    @Override
    public ProductCategory getProductCategoryInfo(String id) {
        return productCategoryMapper.findById(id);
    }

    @Override
    public List<ProductCategory> getProductCategoryList() {
        return productCategoryMapper.findProductCategoryList();
    }
}
