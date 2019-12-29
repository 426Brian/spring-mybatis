package com.transaction.service;

/**
 * Created by Brian in 13:13 2018/11/4
 */

public interface BookShopDao {

    // 根据书号获取书的单价
    int findBookPriceByIsbn(String isbn);

    // 更新书的库存
    void updateBookStock(String isbn);

    // 更新用户账户余额
    void updateUserAcount(String userName, int price);
}
