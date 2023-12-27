package My_First_Project;

class VirtualPerson {
    private String name;


    public VirtualPerson(String name) {
        this.name = name;
    }

    public String sendMessage(String userMessage) {
        // 사용자의 입력에 따라 다양한 응답 생성
        String jkResponse;
        if (userMessage.contains("안녕")) {
            jkResponse = "안녕하세요! 반갑습니다.";
        } else if (userMessage.contains("날씨")) {
            jkResponse = "오늘 날씨는 어떤가요?";
        } else {
            jkResponse = "네, \"" + userMessage + "\"라고 하셨군요. 어떤 이야기를 나누어볼까요?";
        }

        return jkResponse;
    }
}