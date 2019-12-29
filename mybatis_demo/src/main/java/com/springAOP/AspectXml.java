package com.springAOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 此类用于在xml 配置下的切面
 * Created by Brian in 18:10 2018/3/28
 */

public class AspectXml {

    public void a(JoinPoint jp) {
//        通知方法的参数中加入 JoinPoint 来访问连接点的细节
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();
        System.out.println("== 调用 " + methodName + " 之前，参数为： " + Arrays.asList(args));
    }

    public void b() {
        System.out.println("== 调用add() 之后");
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值
     */
    public void c(JoinPoint jp, Object result) {
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();

        System.out.println("== 调用 " + methodName + " 返回值 " + result);
    }

    /**
     * 在目标方法出现异常时会执行的代码
     * 可以访问到异常对象，且可以指定在出现特定异常时再执行
     */
    public void d(JoinPoint jp, Exception ex) {
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();

        System.out.println("== 调用 " + methodName + " 返回值 " + " 出现了异常 " + ex.getMessage());
    }

    /**
     * 环绕通知需要携带 ProceedingJoinPoint 类型的参数
     * 环绕通知类似于动态代理的全过程： ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     *
     * @Param pjp
     */
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("== around method ===");

        Object result = null;
        String methodName = pjp.getSignature().getName();

        // 执行目标方法
        try {
            // 前置通知
            System.out.println("The method " + methodName + "begins with " + Arrays.asList(pjp.getArgs()));
            result = pjp.proceed();
            System.out.println("The method ends with " + methodName + " " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new RuntimeException();
        }
        return result;
    }
}
