package My_First_Project.repository;

import My_First_Project.dto.AccountDTO;
import My_First_Project.dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class MarketRepository {
    private static List<ClientDTO> clientDTOList = new ArrayList<>();
    private static List<AccountDTO> accountDTOList = new ArrayList<>();


    //DTO가 두개이기 때문에 리스트 2개

    public ClientDTO accountCheck(String accountNumber) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                return clientDTO;
            }
        }
        return null;
    }

    // 어카운트 체크 입력 받은 계좌를 for문으로 계속 돌리면서
    // 일치하면 ClientDTO 리턴
    // 없으면 null 리턴


    public boolean save(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }

    public ClientDTO checkBalance(String accountNumber) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                return clientDTO;
            }
        }
        return null;
    }

    public boolean deposit(String accountNumber, long money) {
        for (ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                //일치하는 계좌 찾는 if 문
                long balance = clientDTO.getBalance(); // 기존 잔액 값 가져오기
                balance = balance + money; // 기존 잔액 + 입금액 => 잔액
                clientDTO.setBalance(balance); // 해당 고객의 잔액값으로 저장(set)
                AccountDTO accountDTO = new AccountDTO(accountNumber, money, 0);
                accountDTOList.add(accountDTO);
                return true;
            }
        }
        return false;
    }

    public boolean withdraw(String accountNumber, long money) {
        for (ClientDTO clientDTO : clientDTOList) { //계좌 찾기
            if (accountNumber.equals(clientDTO.getAccountNumber())) { //계좌 찾기
                long balance = clientDTO.getBalance(); //현재 잔액 값 가져오기
                if (money > balance) {
                    return false;
                }
                balance = balance - money;
                clientDTO.setBalance(balance); //잔액값 저장
                AccountDTO accountDTO = new AccountDTO(accountNumber, 0, money); //입금액이 0
                accountDTOList.add(accountDTO);
                return true;
            }
        }
        return false;
    }

    public List<AccountDTO> bankingList(String accountNumber) {
        List<AccountDTO> bankingList = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber())) {
                bankingList.add(accountDTO);
            }
        }
        return bankingList;
    }

    public void transfer(String accountNumberFrom, String accountNumberTo, long money) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if (accountNumberFrom.equals(clientDTOList.get(i).getAccountNumber())) { // 보내는 사람 잔액, 거래 내역 처리
                long balance = clientDTOList.get(i).getBalance();
                balance = balance - money;
                clientDTOList.get(i).setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumberFrom, 0, money);
                accountDTOList.add(accountDTO);
            } else if (accountNumberTo.equals(clientDTOList.get(i).getAccountNumber())) { // 받는 사람 잔액, 거래 내역 처리
                long balance = clientDTOList.get(i).getBalance();
                balance = balance + money;
                clientDTOList.get(i).setBalance(balance);
                AccountDTO accountDTO = new AccountDTO(accountNumberTo, money, 0);
                accountDTOList.add(accountDTO);
            }
        }
    }
}