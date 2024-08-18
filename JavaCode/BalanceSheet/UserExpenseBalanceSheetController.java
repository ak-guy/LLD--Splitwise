package JavaCode.BalanceSheet;

import JavaCode.Expense.Split.Split;
import JavaCode.User.User;
import java.util.Map;
import java.util.List;

public class UserExpenseBalanceSheetController {
    public void updateUserExpense(User user, List<Split> splitDetails, double amount) {
        
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
    }
}
