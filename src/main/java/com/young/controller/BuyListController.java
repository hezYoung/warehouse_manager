package com.young.controller;

import com.young.page.Page;
import com.young.pojo.BuyList;
import com.young.pojo.Store;
import com.young.service.BuyListService;
import com.young.service.StoreService;
import com.young.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    //注入StoreService
    @Autowired
    private StoreService storeService;

    /**
     * 查询所有仓库的url接口/purchase/store-list
     */
    @RequestMapping("/store-list")
    public Result storeList(){
        //执行业务
        List<Store> storeList = storeService.queryAllStore();
        //响应
        return Result.ok(storeList);
    }
    @RequestMapping("/purchase-page-list")
    public Result purchasePageList(Page page, BuyList buyList){
        //执行业务
        page = buyListService.queryPurchasePage(page, buyList);
        //响应
        return Result.ok(page);
    }
    /**
     * 删除采购单的url接口/purchase/purchase-delete/{buyId}
     *
     * @PathVariable Integer buyId将路径占位符buyId的值赋值给参数变量buyId;
     */
    @RequestMapping("/purchase-delete/{buyId}")
    public Result deletePurchase(@PathVariable Integer buyId){
        //执行业务
        Result result = buyListService.deletePurchase(buyId);
        //响应
        return result;
    }

}
