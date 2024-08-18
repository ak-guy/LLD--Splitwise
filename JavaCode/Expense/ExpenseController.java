package JavaCode.Expense;

import JavaCode.BalanceSheet.UserExpenseBalanceSheetController;
import JavaCode.Expense.Split.Split;
import JavaCode.Expense.Split.ExpenseSplit.ExpenseSplit;
import JavaCode.Expense.Split.ExpenseSplit.ExpenseSplitFactory;
import JavaCode.User.User;
import java.util.List;

public class ExpenseController {
    UserExpenseBalanceSheetController balanceSheetControllerObject;

    public ExpenseController() {
        this.balanceSheetControllerObject = new UserExpenseBalanceSheetController();
    }
    
    public Expense creatExpense(String expenseID, String description, User addedByUser, double amountPaid, ExpenseSplitType splitType, List<Split> splitDetails){

        ExpenseSplit expenseSplit = ExpenseSplitFactory.getExpenseSplitObject(splitType);
        boolean isValid = expenseSplit.validateExpense(splitDetails, amountPaid);

        assert isValid == true;

        Expense expense = new Expense(expenseID, description, addedByUser, amountPaid, splitType, splitDetails);
        this.balanceSheetControllerObject.updateUserExpense(addedByUser, splitDetails, amountPaid);
        return expense;
    }
}
