package My_First_Project;


class JkService {
    public boolean login(String userName, String favoriteFood) {
        JkDTO user = new JkDTO(userName, favoriteFood);
        JkRepository.addUserCredentials(user);

        // 사용자의 비밀번호 확인
        String storedPassword = JkRepository.getPassword(userName);

        return storedPassword != null && storedPassword.equals(favoriteFood);
    }
}