package config;

import ex01.ChangePasswordService;
import ex01.MemberDAO;
import ex01.MemberRegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppCtx {
    @Bean
    public MemberDAO memberDAO(){
        return new MemberDAO();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService(memberDAO());
    }
    @Bean
    public ChangePasswordService changePwdSvc(){
        return new ChangePasswordService(memberDAO());
    }
}
