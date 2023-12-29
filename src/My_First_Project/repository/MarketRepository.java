package My_First_Project.repository;

import My_First_Project.dto.AccountDTO;
import My_First_Project.dto.ClientDTO;
import My_First_Project.dto.MemberDTO;
import My_First_Project.dto.ProductDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarketRepository {


    private static final List<ProductDTO> products = new ArrayList<>();


    public static ProductDTO getProductByName(String productName) {
        for (ProductDTO product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static List<ProductDTO> getProducts() {
        return new ArrayList<>(products);
    }
    //DTO가 두개이기 때문에 리스트 2개


    // 어카운트 체크 입력 받은 계좌를 for문으로 계속 돌리면서
    // 일치하면 ClientDTO 리턴
    // 없으면 null 리턴




    public static void addProduct(ProductDTO product) {
        products.add(product);
    }



    public static boolean purchase(MemberDTO member, ProductDTO product, int quantity) {
        // 물건의 총 가격 계산
        int totalCost = product.getPrice() * quantity;

        // 보유 금액이 충분한지 확인
        if (member.getBalance() >= totalCost) {
            // 보유 금액 차감
            member.setBalance(member.getBalance() - totalCost);

            // 물건의 재고 차감
            product.setQuantity(product.getQuantity() - quantity);

            return true; // 구입 성공
        } else {
            return false; // 잔액 부족으로 구입 실패
        }
    }

    public static void removeProduct(ProductDTO product) {
        if (products != null) {
            products.remove(product);
        }
    }
}