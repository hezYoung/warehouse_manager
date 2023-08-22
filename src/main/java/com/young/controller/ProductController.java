package com.young.controller;

import com.young.page.Page;
import com.young.pojo.Brand;
import com.young.pojo.Product;
import com.young.pojo.Store;
import com.young.service.BrandService;
import com.young.service.ProductService;
import com.young.service.StoreService;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/product")
@RestController
public class ProductController {
    //注入StoreService
    @Autowired
    private StoreService storeService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    /**
     * 查询所有仓库的url接口/product/store-list
     * <p>
     * 返回值Result对象给客户端响应查询到的List<Store>;
     */
    @RequestMapping("/store-list")
    public Result storeList() {
        //执行业务
        List<Store> storeList = storeService.queryAllStore();
        //响应
        return Result.ok(storeList);
    }

    /**
     * 查询所有品牌的url接口/product/brand-list
     * <p>
     * 返回值Result对象给客户端响应查询到的List<Brand>;
     */
    @RequestMapping("/brand-list")
    public Result brandList() {
        //执行业务
        List<Brand> brandList = brandService.queryAllBrand();
        //响应
        return Result.ok(brandList);
    }

    @RequestMapping("/product-page-list")
    public Result productpage(Page page, Product product) {
        Page productPage = productService.queryProductPage(page, product);
        return Result.ok(productPage);
    }
}
