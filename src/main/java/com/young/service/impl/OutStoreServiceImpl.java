package com.young.service.impl;

import com.young.pojo.OutStore;
import com.young.vo.Result;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.OutStoreMapper;
import com.young.service.OutStoreService;
@Service
public class OutStoreServiceImpl implements OutStoreService{

    @Resource
    private OutStoreMapper outStoreMapper;

    @Override
    public Result saveOutStore(OutStore outStore) {
        //添加出库单
        int i = outStoreMapper.insertOutStore(outStore);
        if(i>0){
            return Result.ok("添加出库单成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "添加出库单失败！");

    }
}
