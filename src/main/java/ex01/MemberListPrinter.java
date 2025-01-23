package ex01;

import java.util.Collection;

public class MemberListPrinter {
    private  MemberDAO memberDAO;
    private MemberPrinter printer;

    public MemberListPrinter(MemberDAO memberDAO, MemberPrinter memberPrinter) {
        this.memberDAO = memberDAO;
        this.printer=printer;
    }
    public void printAll(){
        Collection<Member>members =memberDAO.selectAll();
        members.forEach(member->printer.print(member));
    }
}
