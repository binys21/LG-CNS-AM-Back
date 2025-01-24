package aop;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {
    /*
    @Pointcut("execution(public * ex04..*(..))")
    private void publicTarget() {

    }
    */

    @Around("aop.CommonPointcut.commonTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long end = System.nanoTime();

            System.out.printf("%s.%s(%s) 실행결과 = %d \n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    joinPoint.getSignature().getName(),
                    Arrays.toString(joinPoint.getArgs()),
                    (end - start));
        }
    }
}