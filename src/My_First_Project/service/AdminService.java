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
        int productPrice = scanner.nextInt();

        System.out.print("물건의 수량을 입력하세요: ");
        int productQuantity = scanner.nextInt();

        // 입력받은 정보를 이용하여 ProductDTO를 생성하고, MarketRepository에 추가하는 로직을 추가합니다.
        ProductDTO productDTO = new ProductDTO(productName, productPrice, productQuantity);
        MarketRepository.addProduct(productDTO);
    }
}