package com.young.service.impl;

import com.young.pojo.ProductType;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.ProductTypeMapper;
import com.young.service.ProductTypeService;

import java.util.ArrayList;
import java.util.List;
//指定缓存的名称即键的前缀,一般是@CacheConfig标注的类的全类名


@Service
public class ProductTypeServiceImpl implements ProductTypeService{

    @Autowired
    private ProductTypeMapper productTypeMapper;
    /*
         查询所有商品分类树的业务方法
        */
    //对查询到的所有商品分类树进行缓存,缓存到redis的键为all:typeTree

    @Override
    public List<ProductType> allProductTypeTree() {
        //查询所有商品分类
        List<ProductType> allTypeList = productTypeMapper.findAllProductType();
        //将所有商品分类List<ProductType>转成商品分类树List<ProductType>
        List<ProductType> typeTreeList = allTypeToTypeTree(allTypeList, 0);
        //返回商品分类树List<ProductType>
        return typeTreeList;

    }
//查看商品id是否存在，前端用的焦点触发事件
    @Override
    public Result queryTypeByCode(String typeCode) {
        //根据分类编码查询商品分类
        ProductType productType = productTypeMapper.findTypeByCode(typeCode);

        return Result.ok(productType==null);

    }

    private List<ProductType> allTypeToTypeTree(List<ProductType> allTypeList, Integer parentId){

        List<ProductType> typeList = new ArrayList<>();
        for (ProductType productType : allTypeList) {
            if(productType.getParentId().equals(parentId)){
                typeList.add(productType);
            }
        }

        for (ProductType productType : typeList) {
            List<ProductType> childTypeList = allTypeToTypeTree(allTypeList, productType.getTypeId());
            productType.setChildProductCategory(childTypeList);
        }

        return typeList;
    }

}
