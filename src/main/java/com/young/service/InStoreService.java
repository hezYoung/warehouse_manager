package com.young.service;

import com.young.pojo.InStore;
import com.young.vo.Result;

public interface InStoreService{
    //添加入库单的业务方法
    public Result saveInStore(InStore inStore, Integer buyId);


}
