package ex01;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class MemberListPrinter {
    @Autowired
    private  MemberDAO memberDAO;
    @Autowired
    private MemberPrinter printer;


    public void printAll(){
        Collection<Member>members =memberDAO.selectAll();
        members.forEach(member->printer.print(member));
    }
}
