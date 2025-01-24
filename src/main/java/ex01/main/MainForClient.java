package ex01.main;

import ex01.config.AppCtx;
import ex02.Client2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainForClient {
    public static void main(String[] args) {
        AbstractApplicationContext ctx= new AnnotationConfigApplicationContext(AppCtx.class);
        Client2 c=ctx.getBean(Client2.class);
        c.send();
        System.out.println("before ctx.close()");
        ctx.close();
        System.out.println("after ctx.close()");


    }
}
