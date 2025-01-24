package ex01;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {
    @Autowired(required = false)
    private DateTimeFormatter dateTimeFormatter;

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
    public void print(Member member) {
        if(dateTimeFormatter==null){
            System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(), member.getEmail(), member.getName(),
                    member.getRegisterDateTime());
        }else{
            System.out.printf("회원정보: ID=%s, 이메일=%s, 이름=%s, 등록일=%tF\n",
                    member.getId(),member.getEmail(),member.getName(), member.getRegisterDateTime());
        }

    }
}
