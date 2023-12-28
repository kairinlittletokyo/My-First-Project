// MarketService.java
package My_First_Project.service;
import My_First_Project.common.CommonVariables;
import My_First_Project.dto.MemberDTO;
import My_First_Project.repository.MemberRepository;

import java.util.Scanner;

public class MemberService {
    private Scanner scanner;

    public MemberService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void deposit() {
        // 로그인 확인
        if (CommonVariables.loggedInMember == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }

        System.out.print("입금할 금액을 입력하세요: ");
        int amount = scanner.nextInt();

        int newBalance = MemberRepository.deposit(CommonVariables.loggedInMember, amount);
        System.out.println("입금이 완료되었습니다. 현재 보유한 금액: " + newBalance);
    }

    public void printBalance() {
        // 로그인 확인
        if (CommonVariables.loggedInMember == null) {
            System.out.println("로그인이 필요합니다.");
            return;
        }

        System.out.println("보유한 금액: " + CommonVariables.loggedInMember.getBalance());
    }

    // 다른 메서드들과 함께...
}
