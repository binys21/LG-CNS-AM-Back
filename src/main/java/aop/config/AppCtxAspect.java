package aop.config;

import aop.ExeTimeAspect;
import ex03.Calculator;
import ex03.ImpCalculator;
import ex03.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxAspect {
    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }
    @Bean
    public Calculator recCalcurator(){
        return new RecCalculator();
    }
    @Bean
    public Calculator impCalculator(){
        return new ImpCalculator();
    }
}
