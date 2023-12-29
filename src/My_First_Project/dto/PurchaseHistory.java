package My_First_Project.dto;

public class PurchaseHistory {
    private MemberDTO member;
    private ProductDTO product;
    private int quantity;
    private int totalPrice;

    public PurchaseHistory(MemberDTO member, ProductDTO product, int quantity, int totalPrice) {
        this.member = member;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "구매자: " + member.getEmail() + // 수정된 부분: getName() 대신 getEmail() 사용
                ", 상품: " + product.getName() +
                ", 수량: " + quantity +
                ", 총 가격: " + totalPrice;
    }
}