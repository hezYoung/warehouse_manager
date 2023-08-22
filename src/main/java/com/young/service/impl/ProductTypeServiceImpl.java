package com.young.service.impl;

import com.young.pojo.ProductType;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.ProductTypeMapper;
import com.young.service.ProductTypeService;

import java.util.ArrayList;
import java.util.List;
//指定缓存的名称即键的前缀,一般是@CacheConfig标注的类的全类名
@CacheConfig(cacheNames = "com.young.service.impl.productTypeServiceImpl")

@Service
public class ProductTypeServiceImpl implements ProductTypeService{

    @Resource
    private ProductTypeMapper productTypeMapper;
    /*
         查询所有商品分类树的业务方法
        */
    //对查询到的所有商品分类树进行缓存,缓存到redis的键为all:typeTree
    @Cacheable(key = "'all:typeTree'")
    @Override
    public List<ProductType> allProductTypeTree() {
        List<ProductType> productType = productTypeMapper.findAllProductType();
        List<ProductType> productTypeList = allTree(productType, 0);
        return productTypeList;
    }

    private List<ProductType> allTree(List<ProductType> allProduct, Integer parentId) {
        ArrayList<ProductType> firstList = new ArrayList<>();
        for (ProductType productType : allProduct) {
            if (productType.getTypeId() == parentId) {
                firstList.add(productType);
            }
        }
        for (ProductType secoundList : firstList) {
            List<ProductType> productTypes = allTree(allProduct, secoundList.getTypeId());
            secoundList.setChildProductCategory(productTypes);
        }
        return firstList;
    }
}
