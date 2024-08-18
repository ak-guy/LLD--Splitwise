package JavaCode.Expense;

import JavaCode.Expense.Split.Split;
import JavaCode.Expense.Split.ExpenseSplit.ExpenseSplit;
import JavaCode.Expense.Split.ExpenseSplit.ExpenseSplitFactory;
import JavaCode.User.User;
import java.util.List;

public class ExpenseController {
    
    public static Expense creatExpense(String expenseID, String description, User addedByUser, double amountPaid, ExpenseSplitType splitType, List<Split> splitDetails){

        ExpenseSplit expenseSplit = ExpenseSplitFactory.getExpenseSplitObject(splitType);
        boolean isValid = expenseSplit.validateExpense(splitDetails, amountPaid);

        assert isValid == true;

        Expense expense = new Expense(expenseID, description, addedByUser, amountPaid, splitType, splitDetails);
        return expense;
    }
}
