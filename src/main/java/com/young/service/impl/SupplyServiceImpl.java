package com.young.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.SupplyMapper;
import com.young.service.SupplyService;
@Service
public class SupplyServiceImpl implements SupplyService{

    @Resource
    private SupplyMapper supplyMapper;

}
