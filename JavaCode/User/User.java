package JavaCode.User;

import JavaCode.BalanceSheet.UserExpenseBalanceSheet;

public class User {
    String userID;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;
    
    public User(String userID, String userName) {
        this.userID = userID;
        this.userName = userName;
        this.userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }

}
