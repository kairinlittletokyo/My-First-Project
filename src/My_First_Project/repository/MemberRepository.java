package My_First_Project.repository;

import java.util.ArrayList;
import java.util.List;

import My_First_Project.dto.MemberDTO;

public class MemberRepository {
    private static List<MemberDTO> memberList = new ArrayList<>();

    public static MemberDTO login(String email, String password) {
        for (MemberDTO member : memberList) {
            if (member.getEmail().equals(email) && member.getPassword().equals(password)) {
                member.setLoggedIn(true);
                return member; // 로그인 성공 시 해당 멤버 반환
            }
        }
        return null; // 로그인 실패 시 null 반환
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
    // 필요에 따라 더 많은 기능을 추가할 수 있습니다.
}