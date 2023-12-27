package My_First_Project.service;

import My_First_Project.dto.MemberDTO;
import My_First_Project.repository.MemberRepository;

import java.util.Scanner;

public class MarketService {
    private Scanner scanner;
    private MemberDTO loggedInMember;

    public MarketService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void login() {
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.next();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.next();

        loggedInMember = MemberRepository.login(email, password);

        if (loggedInMember != null) {
            System.out.println("로그인 성공!");
            if (MemberRepository.isAdminModeEnabled(email)) {
                System.out.println("관리자 모드 활성화! 6번(관리자 모드) 메뉴를 이용할 수 있습니다.");
            }
        } else {
            System.out.println("로그인 실패. 이메일 또는 비밀번호를 확인하세요.");
        }
    }

    // 나머지 메서드에서 loggedInMember를 사용할 때 null 체크를 반드시 해주어야 합니다.
    // (이미 로그인한 상태에서만 사용 가능하도록)

    public void checkmarket() {
        if (loggedInMember != null && loggedInMember.isLoggedIn()) {
            // 3번 메뉴 로직
            System.out.println("마켓 조회 기능 실행");
        } else {
            System.out.println("로그인이 필요한 서비스입니다.");
        }
    }

    public void deposit() {
        if (loggedInMember != null && loggedInMember.isLoggedIn()) {
            // 4번 메뉴 로직
            System.out.println("입금 기능 실행");
        } else {
            System.out.println("로그인이 필요한 서비스입니다.");
        }
    }

    public void bankingList() {
        if (loggedInMember != null && loggedInMember.isLoggedIn()) {
            // 5번 메뉴 로직
            System.out.println("거래내역 확인 기능 실행");
        } else {
            System.out.println("로그인이 필요한 서비스입니다.");
        }
    }

    public void save() {
        System.out.print("이메일을 입력하세요: ");
        String email = scanner.next();

        if (MemberRepository.isEmailExists(email)) {
            System.out.println("이미 존재하는 이메일입니다. 다른 이메일을 입력해주세요.");
            return;
        }

        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.next();
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = scanner.next();

        loggedInMember = MemberRepository.signUp(email, password, phoneNumber);

        if (loggedInMember != null) {
            System.out.println("회원가입이 완료되었습니다.");
        } else {
            System.out.println("이미 존재하는 이메일로 회원가입할 수 없습니다.");
        }
    }
}