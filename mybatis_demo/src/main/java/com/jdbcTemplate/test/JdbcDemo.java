package com.jdbcTemplate.test;

import com.mybatis.model.Emp;

import com.transaction.service.BookShopDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Brian in 0:44 2018/11/4
 */
public class JdbcDemo {

    private static BookShopDao bookShopService;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:conf/spring/jdbcTest/jdbc.xml");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");

        try {
            Connection connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
//        sqlDemo(jdbcTemplate);

//        namedTemplate(namedParameterJdbcTemplate);
    }

    /**
     * 1. 接口 RowMapper 指定如何去映射结果集的行，常用的实现类为 BeanPropertyRowMapper
     * 2. 使用SQL 中列的别名完成列名和类的属性名的映射, 例如 last_name lastName
     * 3. 不支持级联属性, JdbcTemplate 是一个JDBC 小工具, 不是 ORM 框架
     */

    public static void sqlDemo(JdbcTemplate jdbcTemplate) {
        String sql = "select * from EMP";
        List<Map<String, Object>> arr = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : arr) {
//            System.out.println(map);
        }

        List<Emp> arr2 = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Emp.class));
        for (Emp emp : arr2) {
            System.out.println(emp.toString());
        }

    }

    /**
     * 可以为参数起名字
     * 1. 好处：若有多个参数， 则不用去对应位置，直接对应参数名字，便于维护
     * 2. 缺点：较为麻烦
     * 3. 如果以对象的方式传入参数，会很方便
     *
     * @param namedParameterJdbcTemplate
     */
    public static void namedTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        String sql = "insert into emp(empno, gender) values (:empno, :gender)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("empno", 1);
        paramMap.put("gender", "M");

//        int i = namedParameterJdbcTemplate.update(sql, paramMap);

        Emp emp = new Emp();
        emp.setEmpno((short) 2);
        emp.setGender("F");

        SqlParameterSource param = new BeanPropertySqlParameterSource(emp);
//        namedParameterJdbcTemplate.update(sql, param);
    }


}
