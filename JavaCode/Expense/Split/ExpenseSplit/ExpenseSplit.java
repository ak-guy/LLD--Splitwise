package JavaCode.Expense.Split.ExpenseSplit;

import JavaCode.Expense.Split.Split;
import java.util.List;

public interface ExpenseSplit {

    public boolean validateExpense(List<Split> splitDetails, double amountPaid);
}
