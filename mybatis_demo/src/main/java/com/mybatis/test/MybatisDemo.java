package com.mybatis.test;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.dao.DemoUseMapper;
import com.mybatis.dao.DeptMapper;
import com.mybatis.dao.EmpMapper;
import com.mybatis.dao.EmployeeMapper;
import com.mybatis.model.DemoUser;
import com.mybatis.model.Dept;
import com.mybatis.model.DeptExample;
import com.mybatis.model.Emp;
import com.mybatis.util.DbUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Brian in 18:20 2018/3/16
 */
public class MybatisDemo {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
       /* Class clazz = MybatisDemo.class;
        Method[] methods =  clazz.getMethods();
        for (Method m: methods){
            System.out.println(m.getName()+" == "+m.getModifiers());
        }
        System.exit(1);*/
        MybatisDemo mybatisDemo = new MybatisDemo();
        sqlSessionFactory = DbUtil.getSqlSessionFactory();

        SqlSession session = sqlSessionFactory.openSession();
        DemoUseMapper userDao = session.getMapper(DemoUseMapper.class);


        DeptMapper deptMapper = session.getMapper(DeptMapper.class);
//        mybatisDemo.deptInfo(deptMapper);

//        mybatisDemo.listDept(deptMapper);
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        mybatisDemo.empAll(employeeMapper);



//        mybatisDemo.deptOne(deptMapper);

      /*  mybatisDemo.userList(userDao);
        mybatisDemo.user(userDao);
        mybatisDemo.inser(userDao);
        mybatisDemo.update(userDao);
        ;
        mybatisDemo.user(userDao);*/
//        mybatisDemo.delete(userDao);
        session.commit();
        session.close();

    }

    public void user(DemoUseMapper userDao) {
        System.out.println(userDao.getUserById((Integer) 1).toString());
    }

    public void userList(DemoUseMapper userDao) {
        List<DemoUser> userList = userDao.getUserList();
        if (userList != null && userList.size() > 0) {
            for (Iterator<DemoUser> iter = userList.iterator(); iter.hasNext(); ) {
                System.out.println(iter.next().toString());
            }
        }
    }

    public void inser(DemoUseMapper userDao) {
        DemoUser user = new DemoUser();
        user.setUserId((Integer) 5);
        user.setUserName("曹操");
        user.setInTime(new Date());

        userDao.insertUser(user);
    }

    public void update(DemoUseMapper userDao) {
        DemoUser user = new DemoUser();
        user.setUserId((Integer) 5);
        user.setUserName("曹仁");
        user.setInTime(new Date());

        userDao.updateUser(user);
    }

    public void delete(DemoUseMapper userDao) {
        userDao.deleteUser(5);
    }

    public void deptInfo(DeptMapper deptMapper){

        Dept dept = deptMapper.selectByPrimaryKey(Short.parseShort("10"));
        System.out.print(dept.toString());
    }

    public void listDept(DeptMapper deptMapper){
        DeptExample deptExample = new DeptExample();
        DeptExample.Criteria criteria = deptExample.createCriteria();
        criteria.andDeptnoIsNotNull();

        List<Dept> list = (java.util.List<Dept>) deptMapper.selectByExample(deptExample);
        Iterator<Dept> iter = list.iterator();
        int i = 0;
        while(iter.hasNext()){
            i++;
            System.out.println(i+" "+iter.next().toString());
        }

    }
    public void empAndDept(EmpMapper empMapper){
        Emp emp = empMapper.selectemp(Short.parseShort("7369"));
        System.out.print(emp);

    }

    public void deptEmps(DeptMapper deptMapper){
        Dept dept = deptMapper.selectdept(Short.parseShort("10"));
        System.out.print(dept);
    }

    public void deptOne(DeptMapper deptMapper){
        Dept dept = deptMapper.selectonbydept(Short.parseShort("10"));
        System.out.print(dept);
    }

    public void empAll(EmployeeMapper empMapper){
        Page<Object> page = PageHelper.startPage(2, 5);

        List<Emp> emps = empMapper.getEmps();
        System.out.println("当前页第 "+page.getPageNum()+" 页");
        System.out.println("总记录数 "+page.getTotal());
        System.out.println("每页记录数 "+page.getPageSize());
        System.out.println("总页数 "+page.getPages());
        Iterator<Emp> iter = emps.iterator();
        int i = 0;
        while(iter.hasNext()){
            i++;
            Emp emp =  iter.next();
            System.out.println(i+" "+emp.getGender()+" "+emp);
        }
    }
}
