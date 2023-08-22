package com.young.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.BrandMapper;
import com.young.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{

    @Resource
    private BrandMapper brandMapper;

}
