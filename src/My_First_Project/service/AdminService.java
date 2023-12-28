package My_First_Project.service;

import My_First_Project.dto.ProductDTO;
import My_First_Project.repository.MarketRepository;

import java.util.InputMismatchException;
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
        int productPrice = 0;

        // 가격을 입력할 때 정수가 아닌 입력이 들어오면 계속 반복하여 입력을 받습니다.
        while (true) {
            try {
                productPrice = scanner.nextInt();
                break; // 정수가 입력되었으면 반복문을 빠져나갑니다.
            } catch (InputMismatchException e) {
                scanner.next(); // 입력이 잘못되었을 경우 입력 버퍼를 비워줍니다.
            }
        }



        System.out.print("물건의 수량을 입력하세요: ");
        int productQuantity = scanner.nextInt();

        // 입력받은 정보를 이용하여 ProductDTO를 생성하고, MarketRepository에 추가하는 로직을 추가하세요.
        ProductDTO productDTO = new ProductDTO(productName, productPrice, productQuantity);
        MarketRepository.addProduct(productDTO); // 이 부분을 추가해야 합니다.
    }
}