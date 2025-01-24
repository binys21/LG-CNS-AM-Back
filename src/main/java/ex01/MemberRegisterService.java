package ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class MemberRegisterService {
    @Autowired
    private MemberDAO memberDAO;

    public long regist(RegisterRequest req){
        Member member = memberDAO.selectByEmail(req.getEmail());
        if(member!=null){
            throw new DuplicateMemberException("이메일 중복"+req.getEmail());
        }
        Member newMember=new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDAO.insert(newMember);
        return newMember.getId();
    }
}
