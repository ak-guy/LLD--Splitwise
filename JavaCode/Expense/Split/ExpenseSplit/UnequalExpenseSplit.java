package JavaCode.Expense.Split.ExpenseSplit;

import JavaCode.Expense.Split.Split;
import java.util.List;

public class UnequalExpenseSplit implements ExpenseSplit {
    
    public boolean validateExpense(List<Split> splitDetails, double amountPaid) {
        // logic to validate unequal-amount distribution request 
        return true;
    }
}
