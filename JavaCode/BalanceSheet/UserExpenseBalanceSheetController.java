package JavaCode.BalanceSheet;

import JavaCode.Expense.Split.Split;
import JavaCode.User.User;
import java.util.Map;
import java.util.List;

public class UserExpenseBalanceSheetController {
    public void updateUserExpense(User user, List<Split> splitDetails, double amount) {
        UserExpenseBalanceSheet userExpenseSheetObject = user.getUserExpenseBalanceSheet();
        userExpenseSheetObject.setTotalExpense(userExpenseSheetObject.getTotalPaymentDone() + amount);

        for (Split split : splitDetails) {
            // splitUser : is one of the user present in split
            User splitUser = split.getUser();
            UserExpenseBalanceSheet splitUserExpenseSheetObject = splitUser.getUserExpenseBalanceSheet();
            double amountOwe = split.getAmount();

            if (splitUser.getUserID().equals(user.getUserID())) {
                userExpenseSheetObject.setTotalExpense(userExpenseSheetObject.getTotalExpense() + amountOwe);
            }else {
                userExpenseSheetObject.setTotalAmountNeed(userExpenseSheetObject.getTotalAmountNeed() + amountOwe);
                
                // getting the balance object of splitUser to update its toGive parameter
                Balance splitUserBalance;
                if (userExpenseSheetObject.getUserBalance().containsKey(splitUser.getUserID())) {
                    splitUserBalance = userExpenseSheetObject.getUserBalance().get(splitUser.getUserID());
                }else {
                    splitUserBalance = new Balance();
                    userExpenseSheetObject.getUserBalance().put(splitUser.getUserID(), splitUserBalance);
                }
                splitUserBalance.setToGive(splitUserBalance.getToGive() + amount);

                // updating split user's balance sheet object
                splitUserExpenseSheetObject.setTotalExpense(splitUserExpenseSheetObject.getTotalExpense() + amount);
                splitUserExpenseSheetObject.setTotalAmountOwed(splitUserExpenseSheetObject.getTotalAmountOwed() + amount);
                

                // getting the balance object of User to update its toGive parameter
                Balance userBalance;
                if (splitUserExpenseSheetObject.getUserBalance().containsKey(user.getUserID())) {
                    userBalance = splitUserExpenseSheetObject.getUserBalance().get(user.getUserID());
                }else {
                    userBalance = new Balance();
                    splitUserExpenseSheetObject.getUserBalance().put(user.getUserID(), userBalance);
                }
                userBalance.setToGive((userBalance.getToGive() + amount));
            }
        }
        

    }

    public static void getUserBalanceSheet(User user) {
        System.out.println("-----------------------------------------------");
        System.out.println("Balance Sheet of user : " + user.getUserName());

        UserExpenseBalanceSheet balanceSheetObject = user.getUserExpenseBalanceSheet();

        System.out.println("Your Total Expense = " + balanceSheetObject.getTotalExpense());
        System.out.println("Total payment done = " + balanceSheetObject.getTotalPaymentDone());
        System.out.println("Total amount you owe = " + balanceSheetObject.getTotalAmountOwed());
        System.out.println("Total amount you got back = " + balanceSheetObject.getTotalAmountNeed());

        for(Map.Entry<String, Balance> entry: balanceSheetObject.getUserBalance().entrySet()) {
            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("For userID: " + userID + ", you owe: " + balance.getToGive() + " and you get: " + balance.getToReceive());
        }

        System.out.println("\n");
    }
}
