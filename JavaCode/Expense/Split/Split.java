package JavaCode.Expense.Split;

import JavaCode.User.User;

/*
 * from client we will recieve the split for a user
 * like how much he has to give/contribute
 */

public class Split {

    double amountOwe;
    User user;
    int percentageSpilt;
    
    // Constructor to create instance of Split based on amount owed by user in actual currency
    public Split(double amount, User user) {
        this.amountOwe = amount;
        this.user = user;
    }

    // Constructor to create instance of Split based on amount owed by user in percentage
    public Split(int percentageSpilt, User user) {
        this.percentageSpilt = percentageSpilt;
        this.user = user;
    }

    public int getPercentageSpilt() {
        return percentageSpilt;
    }

    public void setPercentageSpilt(int percentageSpilt) {
        this.percentageSpilt = percentageSpilt;
    }

    public double getAmount() {
        return amountOwe;
    }

    public void setAmount(double amount) {
        this.amountOwe = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
