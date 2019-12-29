package com.mybatis.plugin;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Properties;

/**
 * @Intercepts 拦截插件的特定方法
 * Created by Brian in 15:42 2018/4/8
 */
@Intercepts({@Signature(type= StatementHandler.class, method="parameterize", args = Statement.class)})
public class MyFirstPlugin implements Interceptor {
    /**
     * intercpet: 拦截目标对象的目标方法的执行
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("== intercept =="+invocation.getMethod());

        // 执行目标方法
        Object proceed = invocation.proceed();

        // 返回执行后的返回值
        return proceed;
    }

    /**
     * plugin: 包装目标对象：为目标对象创建一个代理对象
     * @param target
     * @return
     * @throws Throwable
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("== plugin =="+target);

        // 我们可以借助Plugin的wrap方法来使用当前Interceptor 包装我们目标对象
        Object wrap = Plugin.wrap(target, this);

        // 返回当前的target创建的动态代理
        return wrap;
    }

    /**
     * setProperties: 将插件注册时的property 属性设值进来
     * @param properties
     * @return
     * @throws Throwable
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件的配置信息： == "+properties);
    }
}
