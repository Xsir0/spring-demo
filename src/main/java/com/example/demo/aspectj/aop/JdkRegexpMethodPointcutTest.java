package com.example.demo.aspectj.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

public class JdkRegexpMethodPointcutTest {

    public static void main(String[] args) {

        ProxyFactory factory = new ProxyFactory(new Person());

//        声明切点
        JdkRegexpMethodPointcut cut = new JdkRegexpMethodPointcut();
        cut.setPatterns(".*run.*", ".*say.*");

//        声明通知
        Advice advice = new MethodInterceptor() {

            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("=======> 放行前拦截...");
                Object proceed = invocation.proceed();
                System.out.println("=======> 放行后拦截...");
                return proceed;
            }
        };

//      声明切面
        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(cut, advice);
        factory.addAdvisor(advisor);

        Person proxy = (Person) factory.getProxy();

        proxy.run();
        proxy.run(10);
        proxy.say();
        proxy.say("Tom", 10);
        proxy.sayHi("Jack");

    }

}


class Person {
    public int run() {
        System.out.println("我在run...");
        return 0;
    }

    public void run(int i) {
        System.out.println("我在run...<" + i + ">");
    }

    public void say() {
        System.out.println("我在say...");
    }

    public void sayHi(String name) {
        System.out.println("Hi," + name + ",你好");
    }

    public int say(String name, int i) {
        System.out.println(name + "----" + i);
        return 0;
    }
}