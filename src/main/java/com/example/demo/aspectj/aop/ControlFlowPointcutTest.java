package com.example.demo.aspectj.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ControlFlowPointcutTest {

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new Person());

        Advice advice = (MethodInterceptor) methodInterceptor->{
            System.out.println("放行前拦截...");
            Object proceed = methodInterceptor.proceed();
            System.out.println("放行后拦截...");
            return proceed;
        };

        ControlFlowPointcut cut = new ControlFlowPointcut(ControlFlowPointcutTest.class,"funabc");

        Advisor advisor = new DefaultPointcutAdvisor(cut,advice);
        factory.addAdvisor(advisor);

        Person person = (Person) factory.getProxy();

        person.run();
        person.run(10);
        person.say();
        person.sayHi("Tom");
        person.say("Jack",121);


        funabc(person);

    }

   private static void funabc(Person p){
        p.sayHi("Tom plus");
   }


}
