package com.example.demo.aspectj.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class IntroductionInterceptorTest implements IntroductionInterceptor,ITest {
    @Override
    public void test() {
        System.out.println("I'm introductionInterceptor test");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        if (implementsInterface(invocation.getMethod().getDeclaringClass())){
            return invocation.getMethod().invoke(this,invocation.getArguments());
        }
        return invocation.proceed();
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return intf.isAssignableFrom(ITest.class);
    }

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new Person());

        proxyFactory.setProxyTargetClass(true);

        Advice advice = new IntroductionInterceptorTest();

        DefaultIntroductionAdvisor advisor = new DefaultIntroductionAdvisor((DynamicIntroductionAdvice) advice, ITest.class);

        proxyFactory.addAdvisor(advisor);

        ITest itest = (ITest)proxyFactory.getProxy();
        itest.test();

        Person person = (Person)proxyFactory.getProxy();

        person.say();
        person.run();



    }

}
