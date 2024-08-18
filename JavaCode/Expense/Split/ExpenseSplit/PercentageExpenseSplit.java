package JavaCode.Expense.Split.ExpenseSplit;

import JavaCode.Expense.Split.Split;
import java.util.List;

public class PercentageExpenseSplit implements ExpenseSplit {
    
    public boolean validateExpense(List<Split> splitDetails, double amountPaid) {
        // logic to validate percentage request 
        return true;
    }
}

