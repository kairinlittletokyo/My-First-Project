package My_First_Project;

public class JkDTO {
    private String userName;
    private String favoriteFood;

    public JkDTO(String userName, String favoriteFood) {
        this.userName = userName;
        this.favoriteFood = favoriteFood;
    }

    public String getUserName() {
        return userName;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    @Override
    public String toString() {
        return "JkDTO{" +
                "userName='" + userName + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }
}
