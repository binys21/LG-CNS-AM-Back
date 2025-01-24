package aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

public class CommonPointcut {
    @Pointcut("execution(public * ex03..*(..))")
    public void commonTarget(){

    }
}

