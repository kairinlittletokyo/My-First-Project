package My_First_Project.dto;

public class MemberDTO {
    private String email;
    private String password;
    private String phoneNumber;
    private boolean loggedIn; // 로그인 상태를 저장하는 변수 추가

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // 예시 생성자
    public MemberDTO(String email, String password, String phoneNumber) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.loggedIn = false; // 초기값은 로그아웃 상태
    }

    // 게터, 세터 등 추가

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}