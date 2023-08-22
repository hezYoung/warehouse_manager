package com.young.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.StoreMapper;
import com.young.service.StoreService;
@Service
public class StoreServiceImpl implements StoreService{

    @Resource
    private StoreMapper storeMapper;

}
