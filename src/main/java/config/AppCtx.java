package config;

import ex01.*;
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
    @Bean
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
    @Bean
    public MemberListPrinter memberListPrinter(){
        return new MemberListPrinter(memberDAO(),memberPrinter());
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDAO(memberDAO());
        infoPrinter.setMemberPrinter(memberPrinter());
        return infoPrinter;
    }
    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(4);
        return versionPrinter;
    }
}
