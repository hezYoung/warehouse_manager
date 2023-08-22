package com.young.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.UnitMapper;
import com.young.service.UnitService;
@Service
public class UnitServiceImpl implements UnitService{

    @Resource
    private UnitMapper unitMapper;

}
