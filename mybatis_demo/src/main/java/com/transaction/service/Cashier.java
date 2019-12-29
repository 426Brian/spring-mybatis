package com.transaction.service;

import java.util.List;

/**
 * Created by Brian in 22:51 2018/11/4
 */
public interface Cashier {
    void checkOut(String userName, List<String> isbns);
}
