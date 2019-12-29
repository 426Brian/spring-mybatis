package com.transaction.service.impl;

import com.transaction.UserAcountException;
import com.transaction.service.BookShopDao;
import com.transaction.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Brian in 20:34 2018/11/4
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 添加事务注解
     * 1. 使用propagation 指定事务的传播行为，即当前的事务方法被另外一个
     * 事务方法调用时，如何使用事务，默认取值为 REQUIRED，即使用调用方法的事务
     * REQUIRED_NEW： 使用自己的事务，调用的事务方法被挂起。
     * 2. 使用Isolation 指定事务的隔离级别，最常用的取值为READ_COMMITED
     * 3. 默认情况下spring 的声明式事务对所有的运行时异常进行回滚。也可以通过
     * 对应的属性值进行设置
     * 4. 使用readOnly 指定事务是否为只读 表示这个事务只读数据但不更新数据
     * 这样可以帮助数据库引擎优化事务，若是一个只读数据库值的方法，应设置
     * readOnly = true
     * 5. 使用timeout 指定强制回滚前事务占用资源时间
     *
     * @Transactional(propagation = Propagation.REQUIRES_NEW,
     * isolation = Isolation.READ_COMMITTED,
     * noRollbackFor = {UserAcountException.class})
     */

    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,
            noRollbackFor = {UserAcountException.class},
            readOnly = false,
            timeout = 20)

    @Override
    public void purchase(String userName, String isbn) {
        // 1. 获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);

        // 2. 更新库存
        bookShopDao.updateBookStock(isbn);

        // 3. 更新用户余额
        bookShopDao.updateUserAcount(userName, price);

    }
}
