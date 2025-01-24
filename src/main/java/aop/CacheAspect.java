package aop;

import java.util.HashMap;
import java.util.Map;

//팩토리알 계산 결과를 캐싱하는 공통 기능
@Aspect
@Order(2)
public class CacheAspect {
    private Map<Long, Object> cache = new HashMap<>();

    /*
    @Pointcut("execution(public * ex04..*(..))")
    public void cacheTarget() {

    }
    */

    @Around("aop.CommonPointcut.commonTarget()")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long num = (Long)joinPoint.getArgs()[0];
        if (cache.containsKey(num)) {
            System.out.printf("CacheAspect: cache에서 가져 옮 [%d]\n", num);
            return cache.get(num);
        }

        Object result = joinPoint.proceed();
        cache.put(num, result);
        System.out.printf("CacheAspect: cache에 추가 [%d]\n", num);
        return result;
    }
}