package main;

import config.AppCtxAspect;
import ex03.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainForAspect {
    public static void main(String[] args) {
        AbstractApplicationContext ctx= new AnnotationConfigApplicationContext(AppCtxAspect.class);
        Calculator imp= ctx.getBean("impCalculator", Calculator.class);
        System.out.println(imp.factorial(10));

        Calculator rec= ctx.getBean("recCalculator",Calculator.class);
        System.out.println(rec.factorial(10));

        ctx.close();
    }
}
