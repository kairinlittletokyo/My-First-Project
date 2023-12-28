package My_First_Project;

import My_First_Project.common.CommonVariables;
import My_First_Project.service.AdminService;
import My_First_Project.service.MarketService;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackmarketMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MarketService marketService = new MarketService(scanner);
        AdminService adminService = new AdminService(new ArrayList<>(), scanner);

        boolean run = true;
        int selectNo = 0;

        while (run) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.마켓 조회 | 4.입금 | 5.거래내역확인 | 6. 관리자모드 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택>  ");
            selectNo = scanner.nextInt();
            if (selectNo == 1) {
                marketService.save(); //회원가입
            } else if (selectNo == 2) {
                marketService.login(); //로그인
            } else if (selectNo == 3) {
                marketService.checkmarket(); //마켓 조회
            } else if (selectNo == 4) {
                marketService.deposit(); // 입금
            } else if (selectNo == 5) {
                marketService.bankingList(); // 거래내역 확인
            } else if (selectNo == 6) {
                boolean adminRun = true;

                // 어드민 로그인 확인
                System.out.print("어드민 비밀번호를 입력하세요: ");
                String adminPassword = scanner.next();

                if ("8888".equals(adminPassword)) {
                    CommonVariables.adminLogin = true;
                    System.out.println("어드민 모드로 진입합니다.");
                } else {
                    System.out.println("어드민 비밀번호가 틀렸습니다.");
                    adminRun = false;
                }

                while (adminRun) {
                    System.out.println("====== 관리자모드 ======");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.println("1.물건 등록 | 2.물건 수정 | 3.물건 삭제 | 0.메인메뉴");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.print("선택> ");
                    selectNo = scanner.nextInt();

                    if (CommonVariables.adminLogin) {
                        if (selectNo == 1) {
                            adminService.save(); // 물건 등록 기능 호출
                        } else if (selectNo == 2) {

                        } else if (selectNo == 3) {

                        } else if (selectNo == 0) {
                            System.out.println("관리자 모드 종료");
                            adminRun = false;
                        } else {
                            System.out.println("유효하지 않은 선택입니다. 다시 선택하세요.");
                        }
                    } else {
                        System.out.println("관리자 모드에 접근할 권한이 없습니다. 로그인 후 다시 시도하세요.");
                        adminRun = false;
                    }
                }
            } else if (selectNo == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}
