package com.transaction;

import com.transaction.service.BookShopDao;
import com.transaction.service.BookShopService;
import com.transaction.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by Brian in 14:35 2018/11/4
 */
public class TransactionTest {
    private ApplicationContext ctx;
    private BookShopDao bookShopDao;
    private BookShopService bookShopService;
    private Cashier cashier;
    {
        ctx = new ClassPathXmlApplicationContext("classpath:conf/spring/jdbcTest/jdbc.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }


    @Test
    public void testCheckout(){
        cashier.checkOut("Brian", Arrays.asList("1101","1102"));
    }
    @Test
    public void testPurchase(){
        bookShopService.purchase("Brian", "1101");
    }
//    @Test
    public void testUpdateAcount() {
        bookShopDao.updateUserAcount("Brian", 60);
    }

//    @Test
    public void testUpdateStock() {
//        bookShopDao.updateBookStock("1101");
    }

//    @Test
    public void testFindPrice() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1101"));
    }


}
