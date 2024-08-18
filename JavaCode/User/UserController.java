package JavaCode.User;

import java.util.*;
import java.util.stream.*;

public class UserController {
    Map<String, User> mappedUserList;

    UserController() {
        this.mappedUserList = new HashMap<>();
    }

    public void addUser(User user) {
        this.mappedUserList.put(user.getUserID(), user);
    }

    public void createUser(String userID, String userName) {
        User user = new User(userID, userName);
        addUser(user);
    }

    public User getUser(String userID) {
        return this.mappedUserList.get(userID);
    }

    /*
     * getAllUsers will return list of all users by converting Collection<User> to List<User>
     */
    public List<User> getAllUsers() {
        Collection<User> collectionObj = this.mappedUserList.values();
        return collectionObj.stream().collect(Collectors.toList());   
    }
}
