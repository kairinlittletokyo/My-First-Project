package My_First_Project.service;

import My_First_Project.dto.ProductDTO;
import My_First_Project.repository.MarketRepository;

import java.util.List;
import java.util.Scanner;

public class AdminService {
    private List<ProductDTO> productList;
    private Scanner scanner;

    public AdminService(List<ProductDTO> productList, Scanner scanner) {
        this.productList = productList;
        this.scanner = scanner;
    }

    public void save() {
        System.out.print("물건의 이름을 입력하세요: ");
        String productName = scanner.next();

        System.out.print(productName + "의 가격을 입력하세요: ");
        int productPrice = scanner.nextInt();

        System.out.print("물건의 수량을 입력하세요: ");
        int productQuantity = scanner.nextInt();

        // 입력받은 정보를 이용하여 ProductDTO를 생성하고, MarketRepository에 추가하는 로직을 추가합니다.
        ProductDTO productDTO = new ProductDTO(productName, productPrice, productQuantity);
        MarketRepository.addProduct(productDTO);
    }

    public void update() {
        List<ProductDTO> products = MarketRepository.getProducts();

        if (!products.isEmpty()) {
            // 등록된 상품 목록 출력
            System.out.println("현재 등록된 상품 목록:");

            for (int i = 0; i < products.size(); i++) {
                ProductDTO product = products.get(i);
                System.out.println((i + 1) + ". 상품명: " + product.getName() +
                        ", 가격: " + product.getPrice() +
                        ", 수량: " + product.getQuantity());
            }

            // 수정할 상품 선택
            System.out.print("몇 번 상품을 수정하시겠습니까? (번호 입력): ");
            int selectedNumber = scanner.nextInt();

            if (selectedNumber >= 1 && selectedNumber <= products.size()) {
                // 선택한 상품의 인덱스 계산
                int selectedIndex = selectedNumber - 1;
                ProductDTO selectedProduct = products.get(selectedIndex);

                // 수정할 내용 입력
                System.out.print("새로운 상품명을 입력하세요: ");
                String newName = scanner.next();

                System.out.print(newName + "의 새로운 가격을 입력하세요: ");
                int newPrice = scanner.nextInt();

                System.out.print(newName + "의 새로운 수량을 입력하세요: ");
                int newQuantity = scanner.nextInt();

                // 선택한 상품 정보 업데이트
                selectedProduct.setName(newName);
                selectedProduct.setPrice(newPrice);
                selectedProduct.setQuantity(newQuantity);

                System.out.println("상품이 수정되었습니다.");
            } else {
                System.out.println("올바른 번호를 입력하세요.");
            }
        } else {
            System.out.println("현재 등록된 상품이 없습니다.");
        }
    }

    public void delete() {
        // 현재 등록된 상품 목록 조회
        List<ProductDTO> products = MarketRepository.getProducts();

        if (!products.isEmpty()) {
            // 등록된 상품 목록 출력
            System.out.println("현재 등록된 상품 목록:");

            for (int i = 0; i < products.size(); i++) {
                ProductDTO product = products.get(i);
                System.out.println((i + 1) + ". 상품명: " + product.getName() +
                        ", 가격: " + product.getPrice() +
                        ", 수량: " + product.getQuantity());
            }

            // 삭제할 상품 선택
            System.out.print("몇 번 상품을 삭제하시겠습니까? (번호 입력): ");
            int selectedNumber = scanner.nextInt();

            if (selectedNumber >= 1 && selectedNumber <= products.size()) {
                // 선택한 상품의 인덱스 계산
                int selectedIndex = selectedNumber - 1;
                ProductDTO selectedProduct = products.get(selectedIndex);

                // 선택한 상품 삭제
                MarketRepository.removeProduct(selectedProduct);

                System.out.println("상품이 삭제되었습니다.");
            } else {
                System.out.println("올바른 번호를 입력하세요.");
            }
        } else {
            System.out.println("현재 등록된 상품이 없습니다.");
        }
    }
}
