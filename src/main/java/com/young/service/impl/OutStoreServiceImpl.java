package com.young.service.impl;

import com.young.page.Page;
import com.young.pojo.OutStore;
import com.young.vo.Result;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.young.mapper.OutStoreMapper;
import com.young.service.OutStoreService;

import java.util.List;

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

    @Override
    public Page outStorePage(Page page, OutStore outStore) {
        //查询出库单总行数
        int outStoreCount = outStoreMapper.outStoreCount(outStore);

        //分页查询出库单
        List<OutStore> outStoreList = outStoreMapper.outStorePage(page, outStore);

        //将查询到的总行数和当前页数据封装到Page对象
        page.setTotalNum(outStoreCount);
        page.setResultList(outStoreList);
        return page;

    }
}
