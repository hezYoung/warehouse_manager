package com.young.controller;

import com.young.pojo.ProductType;
import com.young.service.ProductTypeService;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/productCategory")
@RestController
public class ProductTypeController {

    //注入ProductTypeService
    @Autowired
    private ProductTypeService productTypeService;

    /**
     * 查询商品分类树的url接口/productCategory/product-category-tree
     *
     * 返回值Result对象给客户端响应查询到的所有商品分类树List<ProductType>;
     */
    @RequestMapping("/product-category-tree")
    public Result productCategoryTree(){
        //执行业务
        List<ProductType> productTypeList = productTypeService.allProductTypeTree();
        //响应
        return Result.ok(productTypeList);
    }

}
