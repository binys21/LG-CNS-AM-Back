package aop;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {
    //공통 기능을 적용할 대상
    @Pointcut("execution(public * ex03..*(..))")
    //ex03 패키지와 그 하위패키지의 public 메서드를 pointcut으로 설정
    private void publicTarget(){
        @Around("publicTarget()")
        public Object measure(ProceddingJoinPoint joinPoint) throws Throwable{
            long start = System.nanoTime();
            try{
                Object result= joinPoint.proceed();
                return result;
            }finally {
                long end= System.nanoTime();
                System.out.printf("%s.%s(%s) 실행결과 = %d \n",
                        joinPoint.getTarget().getClass().getSimpleName(),
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()),
                        (end - start));



            }
        }

    }
}
