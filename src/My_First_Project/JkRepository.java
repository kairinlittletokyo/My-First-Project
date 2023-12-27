package My_First_Project;

import java.util.HashMap;
import java.util.Map;

class JkRepository {
    private static final Map<String, String> userCredentials = new HashMap<>();

    public static void addUserCredentials(JkDTO user) {
        userCredentials.put(user.getUserName(), user.getFavoriteFood());
    }

    public static String getPassword(String userName) {
        return userCredentials.get(userName);
    }
}
