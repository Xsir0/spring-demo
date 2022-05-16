package com.example.demo.aspectj.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.aop.support.DelegatePerTargetObjectIntroductionInterceptor;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class DelegatingPerTargetObjectIntroductionInterceptorTest implements ITest {
    @Override
    public void test() {
        System.out.println("I'm introductionInterceptor test");
    }

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new Person());
        proxyFactory.setProxyTargetClass(true);
        Advice advice = new DelegatePerTargetObjectIntroductionInterceptor(DelegatingPerTargetObjectIntroductionInterceptorTest.class,ITest.class);
        Advisor advisor = new DefaultIntroductionAdvisor((DynamicIntroductionAdvice) advice, ITest.class);
        proxyFactory.addAdvisor(advisor);
        ITest itest = (ITest)proxyFactory.getProxy();
        itest.test();
        Person person = (Person)proxyFactory.getProxy();
        person.say();
        person.run();
    }

}
