package com.young.controller;

import com.young.pojo.BuyList;
import com.young.service.BuyListService;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/purchase")
@RestController
public class BuyListController {
    @Autowired
    private BuyListService buyListService;
    /**
     * 添加采购单的url接口/purchase/purchase-add
     */
    @RequestMapping("/purchase-add")
    public Result addPurchase(@RequestBody BuyList buyList){
        //执行业务
        Result result = buyListService.savePurchase(buyList);
        //响应
        return result;
    }

}
