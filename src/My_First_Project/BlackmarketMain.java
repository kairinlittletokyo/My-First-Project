package My_First_Project;

import My_First_Project.service.MarketService;

import java.util.Scanner;

public class BlackmarketMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MarketService marketService = new MarketService(scanner);
        boolean run = true;
        int selectNo = 0;
        while (run) {
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("1.회원가입 | 2.로그인 | 3.마켓 조회 | 4.입금 | 5.거래내역확인 | 6. 관리자모드 | 0.종료");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.print("선택>  ");
            selectNo = scanner.nextInt();
            if (selectNo == 1) {
                marketService.save();
            } else if (selectNo == 2) {
                marketService.login();
            } else if (selectNo == 3) {
                marketService.checkmarket();
            } else if (selectNo == 4) {
                marketService.deposit();
            } else if (selectNo == 5) {
                marketService.bankingList();
//            } else if (selectNo == 6) {
//                boolean adminRun = true;
//                while (boardRun) {
//                    if (CommonVariables.loginEmail != null) {
//                        System.out.println("====== 관리자모드 ======");
//                        System.out.println("-----------------------------------------------------------------------------------------");
//                        System.out.println("1.물건 등록 | 2.물건 목록 | 3.물건 조회 | 4.물건 수정 | 5.물건 삭제 | 6.검색 | 0.메인메뉴");
//                        System.out.println("-----------------------------------------------------------------------------------------");
//                        System.out.print("선택> ");
//                        selectNo = scanner.nextInt();
//                        if (selectNo == 1) {
//                            adminService.save();
//                        } else if (selectNo == 2) {
//                            adminService.findAll();
//                        } else if (selectNo == 3) {
//                            adminService.findById();
//                        } else if (selectNo == 4) {
//                            adminService.update();
//                        } else if (selectNo == 5) {
//                            adminService.delete();
//                        } else if (selectNo == 6) {
//                            adminService.search();
//                        } else if (selectNo == 99) {
//                            adminService.testData();
//                        } else if (selectNo == 0) {
//                            adminRun = false;
//                            adminService.adminmode();
//                        } else if (selectNo == 0) {
//                            System.out.println("종료");
//                        }
//                    }
//                }
//            }
            }
        }
    }
}