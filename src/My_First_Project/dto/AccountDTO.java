package My_First_Project.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDTO { //입출금 내역 기록 DTO
    private Long id;
    private String accountNumber; //어떤 계좌에서 입출금이 발생했는지 번호
    private long deposit; //입금
    private long withdraw; //출금
    private String bankingAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }

    public String getBankingAt() {
        return bankingAt;
    }

    public void setBankingAt(String bankingAt) {
        this.bankingAt = bankingAt;
    }

    private static Long idValue = 1L;

    public AccountDTO() {
    }

    public AccountDTO(String accountNumber, long deposit, long withdraw) {
        this.id = idValue++; //id는 자동
        this.accountNumber = accountNumber;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.bankingAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    //필드에 저장하고 거래시간 기록

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