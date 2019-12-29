package com.mybatis.controller;

import com.mybatis.model.Emp;
import com.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Brian in 13:34 2018/4/5
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/getemps")
    public String emps(HttpServletRequest request) {
        Emp emp = new Emp();
        emp.setEmpno(Short.parseShort("7369"));

        emp = employeeService.getbyEmpno(emp);

        List<Emp> list = employeeService.getEmps();
        System.out.println("size == " + list.size());
        String name = "Tom";

        request.setAttribute("name", name);
        request.setAttribute("emp", emp);
        request.setAttribute("emps", list);

        return "emp";
    }

    @RequestMapping("/test")
    public String test2() {

        return "emp";
    }
}
