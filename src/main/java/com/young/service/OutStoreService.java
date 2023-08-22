package com.young.service;

import com.young.pojo.OutStore;
import com.young.vo.Result;

public interface OutStoreService{
    //添加出库单的业务方法
    public Result saveOutStore(OutStore outStore);

}
