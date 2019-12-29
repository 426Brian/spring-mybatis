package com.transaction.service.impl;

import com.transaction.service.BookShopService;
import com.transaction.service.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Brian in 22:52 2018/11/4
 */
@Service("cashier")
public class CashierImpl implements Cashier {
    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkOut(String userName, List<String> isbns) {
        for(String ibns: isbns){
            bookShopService.purchase(userName, ibns);
        }
    }
}
