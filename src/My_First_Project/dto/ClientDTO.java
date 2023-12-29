package My_First_Project.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientDTO {
    private Long id;
    private String clientName;
    private String accountNumber;
    private String clientPass;
    private String clientCreatedAt;
    private long balance = 0; //잔고는 long으로 기본형 타입(소문자)


    //각각의 getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientPass() {
        return clientPass;
    }

    public void setClientPass(String clientPass) {
        this.clientPass = clientPass;
    }

    public String getClientCreatedAt() {
        return clientCreatedAt;
    }

    public void setClientCreatedAt(String clientCreatedAt) {
        this.clientCreatedAt = clientCreatedAt;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


    private static Long idValue = 1L;
    //ID값을 부여하기 위한 변수

    public ClientDTO() {
    }

    public ClientDTO(String clientName, String accountNumber, String clientPass) {
        this.id = idValue++; //자동으로 늘어나는 Id
        this.clientName = clientName; //위에 string에서 전달 받은 값을 필드값으로
        this.accountNumber = accountNumber;
        this.clientPass = clientPass;
        this.clientCreatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    } // 객체를 만드는 순간에 시간이 나오게끔


    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", clientPass='" + clientPass + '\'' +
                ", clientCreatedAt='" + clientCreatedAt + '\'' +
                ", balance=" + balance +
                '}';
    }
}