package com.example.demo.aspectj.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectJExpressionPointcutTest {

    public static void main(String[] args) {
        //String pointcutExpression = "execution( int com.fsx.maintest.Person.run() )"; // 会拦截Person.run()方法
        String pointcutExpression = "args()"; // 所有没有入参的方法会被拦截。  比如：run()会拦截,但是run(int i)不会被拦截
        // ... AspectJExpressionPointcut支持的表达式 一共有11种（也就是Spring全部支持的切点表达式类型）
//        String pointcutExpression = "@annotation(org.springframework.test.context.transaction.AfterTransaction)"; // 拦截上方法标有@AfterTransaction此注解的任意方法们

        ProxyFactory factory = new ProxyFactory(new Person());

//      声明一个切点
        AspectJExpressionPointcut cut = new AspectJExpressionPointcut();
        cut.setExpression(pointcutExpression);

        Advice advice = (MethodInterceptor)e -> {
            System.out.println("放行前拦截...");
            Object proceed = e.proceed();
            System.out.println("放行后拦截...");
            return proceed;
        };

        Advisor advisor = new DefaultPointcutAdvisor(cut,advice);

        factory.addAdvisor(advisor);
        Person person = (Person) factory.getProxy();
        person.say();
        person.sayHi("tom");


    }

}
