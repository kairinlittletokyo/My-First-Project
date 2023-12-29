package My_First_Project.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDTO { //입출금 내역 기록 DTO
    private Long id;
    private String accountNumber; //어떤 계좌에서 입출금이 발생했는지 번호
    private long deposit; //입금
    private long withdraw; //출금
    private String bankingAt;



    public AccountDTO() {
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", bankingAt='" + bankingAt + '\'' +
                '}';
    }
}