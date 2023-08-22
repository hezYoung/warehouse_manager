package com.young.mapper;

import com.young.pojo.ProductType;

import java.util.List;

public interface ProductTypeMapper {
    //查询所有商品分类的方法
    public List<ProductType> findAllProductType();

}