package My_First_Project.repository;

import java.util.ArrayList;
import java.util.List;

import My_First_Project.common.CommonVariables;
import My_First_Project.dto.MemberDTO;

public class MemberRepository {
    private static List<MemberDTO> memberList = new ArrayList<>();

    public static MemberDTO login(String email, String password) {
        for (MemberDTO member : memberList) {
            if (member.getEmail().equals(email) && member.getPassword().equals(password)) {
                CommonVariables.loggedInMember = member; // 로그인한 멤버 설정
                return member;
            }
        }
        return null;
    }

    public static boolean isAdminModeEnabled(String email) {
        return email.equals("88888"); // 특정 이메일로 관리자 모드 활성화 여부 확인
    }

    public static boolean isEmailExists(String email) {
        for (MemberDTO member : memberList) {
            if (member.getEmail().equals(email)) {
                return true; // 이미 존재하는 이메일
            }
        }
        return false; // 존재하지 않는 이메일
    }

    public static void save(MemberDTO member) {
        memberList.add(member);
    }

    public static int deposit(MemberDTO member, int amount) {
        // 계정에 입금
        member.setBalance(member.getBalance() + amount);
        return member.getBalance();
    }


    // 회원가입 기능 추가
    public static MemberDTO signUp(String email, String password, String phoneNumber) {
        if (!isEmailExists(email)) {
            MemberDTO memberDTO = new MemberDTO(email, password, phoneNumber);
            save(memberDTO);
            return memberDTO; // 회원가입 성공 시 해당 멤버 반환
        } else {
            return null; // 이미 존재하는 이메일로 회원가입 실패
        }
    }

}