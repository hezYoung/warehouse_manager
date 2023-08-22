package com.young.service;

import com.young.page.Page;
import com.young.pojo.Product;

public interface ProductService{
    //分页查询商品的业务方法
    public Page queryProductPage(Page page, Product product);

}
