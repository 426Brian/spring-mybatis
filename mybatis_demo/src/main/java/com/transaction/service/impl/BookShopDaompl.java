package com.transaction.service.impl;

import com.transaction.BookStockException;
import com.transaction.UserAcountException;
import com.transaction.service.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Brian in 13:16 2018/11/4
 */
@Repository("bookShopDao")
public class BookShopDaompl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn = ?";

        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        // 检查书的库存是否足够，若不够，则抛出异常
        String sql2 = "select stock from book_stock where isbn = ?";

        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock == 0) {
            throw new BookStockException("库存不足");
        }

        String sql = "update book_stock set stock = stock - 1 where isbn = ?";
        System.out.println("库存减少 === " + jdbcTemplate.update(sql, isbn));
    }

    @Override
    public void updateUserAcount(String userName, int price) {
        // 检查账户的余额是否足够，若不够，则抛出异常
        String sql2 = "select money from account where name = ?";

        int money = jdbcTemplate.queryForObject(sql2, Integer.class, userName);
        if (money < price) {
            throw new UserAcountException("余额不足");
        }
        String sql = "update account set money = money - ? where name = ?";
        System.out.println("余额减少 === " +jdbcTemplate.update(sql, new Object[]{price, userName}));
    }
}
