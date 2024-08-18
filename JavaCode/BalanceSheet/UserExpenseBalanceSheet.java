package JavaCode.BalanceSheet;

import java.util.Map;
import java.util.HashMap;

public class UserExpenseBalanceSheet {

    // userBalance will tell us about which user owes/need to/from current user, userID : BalanceObj
    Map<String, Balance> userBalance;
    double totalExpense;
    double totalPaymentDone;
    double totalAmountOwed;
    double totalAmountNeed;

    public UserExpenseBalanceSheet() {
        this.userBalance = new HashMap<>();
        this.totalExpense = 0;
        this.totalPaymentDone = 0;
        this.totalAmountNeed = 0;
        this.totalAmountOwed = 0;
    }

    public Map<String, Balance> getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(Map<String, Balance> userBalance) {
        this.userBalance = userBalance;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPaymentDone() {
        return totalPaymentDone;
    }

    public void setTotalPaymentDone(double totalPaymentDone) {
        this.totalPaymentDone = totalPaymentDone;
    }

    public double getTotalAmountOwed() {
        return totalAmountOwed;
    }

    public void setTotalAmountOwed(double totalAmountOwed) {
        this.totalAmountOwed = totalAmountOwed;
    }

    public double getTotalAmountNeed() {
        return totalAmountNeed;
    }

    public void setTotalAmountNeed(double totalAmountNeed) {
        this.totalAmountNeed = totalAmountNeed;
    }

}
