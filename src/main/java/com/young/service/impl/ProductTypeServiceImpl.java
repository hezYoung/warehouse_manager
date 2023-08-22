package com.young.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.ProductTypeMapper;
import com.young.service.ProductTypeService;
@Service
public class ProductTypeServiceImpl implements ProductTypeService{

    @Resource
    private ProductTypeMapper productTypeMapper;

}
