package ex01;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private MemberPrinter printer;

    public void printMemberInfo(String email){
        Member member=memberDAO.selectByEmail(email);
        if(member==null){
            System.out.println("일치하는 데이터가 없습니다.");
            return;
        }
        printer.print(member);
        System.out.println();
    }
}
