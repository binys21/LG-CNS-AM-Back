package ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePasswordService {
    @Autowired
    private MemberDAO memberDAO;

    public void changePassword(String email,String currentPw,String newPw){
        Member member=memberDAO.selectByEmail(email);
        if(member==null){
            throw new RuntimeException("등록한 회원이 없습니다.");
        }

        member.changePassword(currentPw, newPw);
        memberDAO.update(member);

    }
}
