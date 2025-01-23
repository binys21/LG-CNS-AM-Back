package ex01;

public class MemberInfoPrinter {
    private MemberDAO memberDAO;
    private MemberPrinter printer;

    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }
    public void setMemberPrinter(MemberPrinter printer) {
        this.printer = printer;
    }

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
