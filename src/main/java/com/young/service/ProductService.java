package com.young.service;

import com.young.page.Page;
import com.young.pojo.Product;
import com.young.vo.Result;

public interface ProductService{
    //分页查询商品的业务方法
    public Page queryProductPage(Page page, Product product);
    //添加商品的业务方法
    public Result saveProduct(Product product);

}
