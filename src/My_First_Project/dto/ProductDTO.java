package My_First_Project.dto;

public class ProductDTO {
    private String name; // 물건 이름
    private int price; // 물건 가격
    private int quantity; // 물건 갯수

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // 생성자, 게터, 세터 등 필요한 메서드 추가

    // 예시 생성자
    public ProductDTO(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

//    public void decreaseQuantity(int quantity) {
//        this.quantity -= quantity;

    }