package com.young.controller;

import com.young.page.Page;
import com.young.pojo.*;
import com.young.service.*;
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
    //注入ProductTypeService
    @Autowired
    private ProductTypeService productTypeService;
    //注入SupplyService
    @Autowired
    private SupplyService supplyService;
    //注入PlaceService
    @Autowired
    private PlaceService placeService;


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


    /**
     * 查询所有商品分类树的url接口/product/category-tree
     *
     * 返回值Result对象给客户端响应查询到的所有商品分类树List<ProductType>;
     */
    @RequestMapping("/category-tree")
    public Result categoryTree(){
        //执行业务
        List<ProductType> typeTreeList = productTypeService.allProductTypeTree();
        //响应
        return Result.ok(typeTreeList);
    }
    /**
     * 查询所有供应商的url接口/product/supply-list
     *
     * 返回值Result对象给客户端响应查询到的List<Supply>;
     */
    @RequestMapping("/supply-list")
    public Result supplyList(){
        //执行业务
        List<Supply> supplyList = supplyService.queryAllSupply();
        //响应
        return Result.ok(supplyList);
    }

    /**
     * 查询所有产地的url接口/product/place-list
     *
     * 返回值Result对象给客户端响应查询到的List<Place>;
     */
    @RequestMapping("/place-list")
    public Result placeList(){
        //执行业务
        List<Place> placeList = placeService.queryAllPlace();
        //响应
        return Result.ok(placeList);
    }

}
