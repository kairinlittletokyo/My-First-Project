package My_First_Project;

import java.util.Scanner;

public class JkMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("입장 테스트");

        // 사용자 이름 설정
        System.out.println("■■■■■■■■■■■■■■ 내 이름은 ■■■■■■■■■■■■■■ ");
        System.out.print("이름을 입력하세요 : ");
        String userName = scanner.nextLine();

        // 사용자 비밀번호 설정
        System.out.println("의문의 여성 : " + userName + " 이(가) 좋아하는 음식");
        System.out.println("■■■■■■■■■■■■■■ 내가 좋아하는 음식은  ■■■■■■■■■■■■■■ ");
        System.out.print("음식을 입력하세요 : ");
        String favoriteFood = scanner.nextLine();

        // 사용자 정보 저장 및 로그인
        JkService jkService = new JkService();
        boolean loginSuccess = jkService.login(userName, favoriteFood);

        if (loginSuccess) {
            System.out.println("역시! 제가 알고있던 " + userName + "님이 맞으시군요.");

            // 가상의 인물 JK 생성
            VirtualPerson jk = new VirtualPerson("JK");

            // 채팅 시작
            while (true) {
                System.out.print(userName + ": ");
                String userMessage = scanner.nextLine();

                // 종료 조건
                if ("exit".equalsIgnoreCase(userMessage)) {
                    System.out.println("채팅을 종료합니다. 프로그램을 종료합니다.");
                    break;
                }

                // 사용자의 메시지를 JK에게 전송
                String jkResponse = jk.sendMessage(userMessage);
                System.out.println("JK: " + jkResponse);
            }
        } else {
            System.out.println("로그인 실패! 사용자 정보를 확인하세요.");
        }

        scanner.close();
    }
}
