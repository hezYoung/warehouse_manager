package com.young.service.impl;

import com.young.pojo.BuyList;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.BuyListMapper;
import com.young.service.BuyListService;
@Service
public class BuyListServiceImpl implements BuyListService{

    @Autowired
    private BuyListMapper buyListMapper;

    @Override
    public Result savePurchase(BuyList buyList) {
        //添加采购单
        int i = buyListMapper.insertPurchase(buyList);
        if(i>0){
            return Result.ok("采购单添加成功！");
        }
        return Result.err(Result.CODE_ERR_BUSINESS, "采购单添加失败！");
    }

}
