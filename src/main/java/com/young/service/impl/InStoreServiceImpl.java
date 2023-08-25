package com.young.service.impl;

import com.young.mapper.BuyListMapper;
import com.young.pojo.InStore;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.InStoreMapper;
import com.young.service.InStoreService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InStoreServiceImpl implements InStoreService{

    @Resource
    private InStoreMapper inStoreMapper;
    @Autowired
    private BuyListMapper buyListMapper;
    //添加入库单的业务方法
    @Transactional//事务处理
    @Override
    public Result saveInStore(InStore inStore, Integer buyId) {
        //添加入库单
        int i = inStoreMapper.insertInStore(inStore);
        if(i>0){
            //根据id将采购单状态改为已入库
            int j = buyListMapper.updateIsInById(buyId);
            if(j>0){
                return Result.ok("入库单添加成功！");
            }
            return Result.err(Result.CODE_ERR_BUSINESS, "入库单添加失败！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "入库单添加失败！");
    }

}
