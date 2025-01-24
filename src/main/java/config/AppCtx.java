package config;

import ex01.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages = {"ex01"})
public class AppCtx {
    @Bean
    public MemberDAO memberDAO(){
        return new MemberDAO();
    }

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService();
    }
    @Bean
    public ChangePasswordService changePwdSvc(){
        return new ChangePasswordService();
    }
    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter(){
        return new MemberPrinter();
    }
    @Bean
    public MemberListPrinter memberListPrinter(){
        return new MemberListPrinter();
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
    @Bean
    public MemberSummaryPrinter memberPrinter2(){
        return new MemberSummaryPrinter();
    }
}
