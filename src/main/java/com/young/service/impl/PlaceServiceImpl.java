package com.young.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.PlaceMapper;
import com.young.service.PlaceService;
@Service
public class PlaceServiceImpl implements PlaceService{

    @Resource
    private PlaceMapper placeMapper;

}
