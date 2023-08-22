package com.young.service.impl;

import com.young.page.Page;
import com.young.pojo.Product;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.ProductMapper;
import com.young.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductMapper productMapper;

    @Override
    public Page queryProductPage(Page page, Product product) {
        int productCount = productMapper.selectProductCount(product);
        List<Product> productPage = productMapper.selectProductPage(page, product);
        page.setTotalNum(productCount);
        page.setResultList(productPage);
        return page;
    }
}
