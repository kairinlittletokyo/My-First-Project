package My_First_Project.service;

import My_First_Project.common.CommonVariables;
import My_First_Project.dto.MemberDTO;
import My_First_Project.dto.ProductDTO;
import My_First_Project.repository.MemberRepository;
import My_First_Project.repository.MarketRepository;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarketService {
    private Scanner scanner;
    private MemberDTO loggedInMember;


    private List<ProductDTO> productList;

    public MarketService(Scanner scanner) {
        this.scanner = scanner;
        this.productList = new ArrayList<>();
    }


    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }

    public void printBalance(MemberDTO member) {
        if (member != null) {
            System.out.println("고객님의 잔고: " + member.getBalance());
        } else {
            System.out.println("로그인이 필요합니다.");
        }
    }

    public void login() {
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

    public boolean hasProducts() {
        return !productList.isEmpty();
    }
    //
    // (이미 로그인한 상태에서만 사용 가능하도록)


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
        String phoneNumber = scanner.next(); // 이 부분을 올림

        loggedInMember = MemberRepository.signUp(email, password, phoneNumber);

        if (loggedInMember != null) {
            System.out.println("회원가입이 완료되었습니다.");
        } else {
            System.out.println("이미 존재하는 이메일로 회원가입할 수 없습니다.");
        }
    }

    public boolean purchaseProduct(MemberDTO member, ProductDTO product, int quantity) {
        if (member != null && product != null && quantity > 0) {
            ProductDTO selectedProduct = MarketRepository.getProductByName(product.getName());

            if (selectedProduct != null) {
                int totalPrice = selectedProduct.getPrice() * quantity;
                if (member.getBalance() >= totalPrice && selectedProduct.getQuantity() >= quantity) {
                    // 구매 가능한 경우
                    member.setBalance(member.getBalance() - totalPrice);
                    selectedProduct.setQuantity(selectedProduct.getQuantity() - quantity);
                    // 구매 내역 추가 등의 로직도 추가 가능
                    return true; // 구매 성공
                } else {
                    System.out.println("잔액이 부족하거나 해당 상품의 재고가 부족하여 구매할 수 없습니다.");
                }
            } else {
                System.out.println("상품을 찾을 수 없습니다.");
            }
        }
        return false; // 구매 실패
    }

    public void checkmarket() {
        if (loggedInMember != null) {
            List<ProductDTO> products = MarketRepository.getProducts();
            if (!products.isEmpty()) {
                System.out.println("상점에 등록된 물건들:");

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
