package My_First_Project.service;

import My_First_Project.dto.ProductDTO;

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
        System.out.print("상품명을 입력하세요: ");
        String name = scanner.next();
        System.out.print("가격을 입력하세요: ");
        int price = scanner.nextInt();
        System.out.print("수량을 입력하세요: ");
        int quantity = scanner.nextInt();

        ProductDTO product = new ProductDTO(name, price, quantity);
        productList.add(product);

        System.out.println("물건이 등록되었습니다.");
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }
}