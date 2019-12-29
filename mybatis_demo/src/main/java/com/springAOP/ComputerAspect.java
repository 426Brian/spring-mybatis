package com.springAOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * Created by Brian in 18:10 2018/3/28
 */
@Order(2)
@Aspect
@Component
public class ComputerAspect {

  /*  @Before("execution(public int com.springAOP.service.Computer.add(int, int))")
    public void a(){
        System.out.println("== 调用add() 之前");
    }

    @After("execution(public int com.springAOP.service.Computer.add(int, int))")
    public void b(){
        System.out.println("== 调用add() 之后");
    }*/

    /**
     * 定义一个方法用于声明切入点表达式，一般的，该方法中不需要有操作
     * 作为提供其他通知应用的公用部分，例子如@Before 的使用
     */

    @Pointcut("execution(public int com.springAOP.service.impl.ComputerImpl2.*(..))")

    public void declareJoinPoint() {
    }


    //    *: 通配符，所有
//    ..: 在方法的参数列表中使用，不限定参数类型，顺序，个数
    @Before("declareJoinPoint()")
    public void a(JoinPoint jp) {
//        通知方法的参数中加入 JoinPoint 来访问连接点的细节
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();
        System.out.println("== 调用 " + methodName + " 之前，参数为： " + Arrays.asList(args));
    }

    @After("execution(public int com.springAOP.service.impl.ComputerImpl2.*(..))")
    public void b() {
        System.out.println("== 调用add() 之后");
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值
     */
    @AfterReturning(pointcut = "execution(public int com.springAOP.service.impl.ComputerImpl2.*(..))", returning = "result")
    public void c(JoinPoint jp, Object result) {
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();

        System.out.println("== 调用 " + methodName + " 返回值 " + result);
    }

    /**
     * 在目标方法出现异常时会执行的代码
     * 可以访问到异常对象，且可以指定在出现特定异常时再执行
     */
    @AfterThrowing(pointcut = "execution(public int com.springAOP.service.impl.ComputerImpl2.*(..))", throwing = "ex")
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
    @Around("execution(public int com.springAOP.service.impl.ComputerImpl2.*(..))")
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
