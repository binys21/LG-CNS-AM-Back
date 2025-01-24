package ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class MemberListPrinter {
    @Autowired
    private  MemberDAO memberDAO;
    @Autowired
    private MemberSummaryPrinter printer;


    public void printAll(){
        Collection<Member>members =memberDAO.selectAll();
        members.forEach(member->printer.print(member));
    }
}
