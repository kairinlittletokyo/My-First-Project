package My_First_Project.service;

import My_First_Project.common.CommonVariables;
import My_First_Project.dto.MemberDTO;
import My_First_Project.dto.ProductDTO;
import My_First_Project.dto.PurchaseHistory;
import My_First_Project.repository.MemberRepository;
import My_First_Project.repository.MarketRepository;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketService {

    private List<PurchaseHistory> purchaseHistories = new ArrayList<>();
    private Scanner scanner;
    private MemberDTO loggedInMember;


    private List<ProductDTO> productList;

    public MarketService(Scanner scanner) {
        this.scanner = scanner;
        this.productList = new ArrayList<>();
    }


    public void login() {
        if (loggedInMember != null) {
            System.out.println("이미 로그인 되어있습니다.");
            return;
        }

        System.out.print("이메일을 입력하세요: ");
        String email = scanner.next();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.next();

        loggedInMember = MemberRepository.login(email, password);

        if (loggedInMember != null) {
            System.out.println("로그인 성공!");
        } else {
            System.out.println("로그인 실패. 이메일 또는 비밀번호를 확인하세요.");
        }
    }

    public void deposit() {
        if (CommonVariables.loggedInMember != null) {
            System.out.print("입금할 금액을 입력하세요: ");
            int amount = scanner.nextInt();

            int newBalance = MemberRepository.deposit(CommonVariables.loggedInMember, amount);
            System.out.println("입금이 완료되었습니다. 현재 보유한 금액: " + newBalance);
        } else {
            System.out.println("로그인이 필요합니다.");
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
        String phoneNumber = scanner.next(); // 이 부분을 올림

        loggedInMember = MemberRepository.signUp(email, password, phoneNumber);

        if (loggedInMember != null) {
            System.out.println("회원가입이 완료되었습니다.");
        } else {
            System.out.println("이미 존재하는 이메일로 회원가입할 수 없습니다.");
        }
    }

    public boolean purchaseProduct(MemberDTO member, ProductDTO product, int quantity) {
        // 구매 가능한 경우 처리
        if (member != null && product != null && quantity > 0) {
            int totalPrice = product.getPrice() * quantity;
            if (member.getBalance() >= totalPrice && product.getQuantity() >= quantity) {
                // 구매 가능한 경우
                member.setBalance(member.getBalance() - totalPrice);
                product.setQuantity(product.getQuantity() - quantity);

                // 거래 내역 추가
                PurchaseHistory purchaseHistory = new PurchaseHistory(member, product, quantity, totalPrice);
                purchaseHistories.add(purchaseHistory);

                return true; // 구매 성공
            } else {
                System.out.println("잔액이 부족하거나 해당 상품의 재고가 부족하여 구매할 수 없습니다.");
            }
        }
        return false; // 구매 실패
    }

    // 거래 내역 출력 메서드
    public void printPurchaseHistories() {
        System.out.println("거래 내역:");
        for (PurchaseHistory history : purchaseHistories) {
            System.out.println(history.toString());
        }
    }

    public void checkmarket() {
        if (loggedInMember != null) {
            List<ProductDTO> products = MarketRepository.getProducts();
            if (!products.isEmpty()) {
                System.out.println("■■■■■■■■■■■■■■■■ 블랙마켓에 오신 것을 환영합니다! ■■■■■■■■■■■■■■■■");

                for (ProductDTO product : products) {
                    System.out.println("상품명: " + product.getName() +
                            ", 가격: " + product.getPrice() +
                            ", 수량: " + product.getQuantity());
                }

                System.out.println("고객님의 잔고: " + loggedInMember.getBalance());

                System.out.print("물건을 구매하시겠습니까? (Y/N): ");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.print("구매할 물건의 이름을 입력하세요: ");
                    String productName = scanner.next();

                    // 물건 이름으로 해당 상품을 찾습니다.
                    ProductDTO selectedProduct = MarketRepository.getProductByName(productName);

                    if (selectedProduct != null) {
                        System.out.print("구매할 수량을 입력하세요: ");
                        int quantity = scanner.nextInt();

                        // 물건 구입 시도
                        if (purchaseProduct(loggedInMember, selectedProduct, quantity)) {
                            System.out.println("구입이 완료되었습니다.");
                        } else {
                            System.out.println("구입이 실패하였습니다.");
                        }
                    } else {
                        System.out.println("해당 상품이 존재하지 않습니다.");
                    }
                }
            } else {
                System.out.println("상점에 재고가 없습니다.");
            }
        } else {
            System.out.println("로그인이 필요합니다.");
        }
    }
}

