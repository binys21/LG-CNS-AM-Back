package ex01.main;

import config.AppCtx;
import ex01.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainforSpring {
    private static ApplicationContext ctx=null;

    public static void main(String[] args) {
        ctx= new AnnotationConfigApplicationContext(AppCtx.class);
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("명령어를 입력하세요. ");
            String command=reader.readLine();
            if (command.startsWith("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if (command.startsWith("new")) {
                processNewCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("change")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("list")) {
                processListCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("info")) {
                processInfoCommand(command.split(" "));
                continue;

            }
            printHelp();

        }
    }

    private static void processInfoCommand(String[] args) {
        if(args.length != 2) {
            printHelp();
            return;
        }
        MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
        memberInfoPrinter.printMemberInfo(args[1]);
    }
    private static void processListCommand(String[] args) {
        MemberListPrinter memberListPrinter=ctx.getBean("memberListPrinter", MemberListPrinter.class);
        memberListPrinter.printAll();
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("new email name password confirmPassword");
        System.out.println("change email currentPassword newPassword");
        System.out.println();

    }
    private static void processNewCommand(String[] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }
        // MemberRegisterService regSvc = assembler.getRegSvc();
        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        RegisterRequest reg = new RegisterRequest();
        reg.setEmail(args[1]);
        reg.setName(args[2]);
        reg.setPassword(args[3]);
        reg.setConfirmPassword(args[4]);

        if (!reg.isPasswordEqualToConfirmPassword()) {
            System.out.println("패스워드와 패스워드 확인이 일치하지 않습니다.");
            return;
        }

        try {
            regSvc.regist(reg);
            System.out.println("등록되었습니다.");
        } catch(DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.");
        }
    }

    private static void processChangeCommand(String[] args) {
        if (args.length != 4) {
            printHelp();
            return;
        }

        // ChangePasswordService pwdSvc = assembler.getPwdSvc();
        ChangePasswordService pwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
        try {
            pwdSvc.changePassword(args[1], args[2], args[3]);
            System.out.println("패스워드를 변경하였습니다.");
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}


