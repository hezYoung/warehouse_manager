package com.young.service;

import com.young.pojo.BuyList;
import com.young.vo.Result;

public interface BuyListService{
    //添加采购单的业务方法
    public Result savePurchase(BuyList buyList);

}
