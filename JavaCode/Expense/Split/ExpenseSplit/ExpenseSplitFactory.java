package JavaCode.Expense.Split.ExpenseSplit;

import JavaCode.Expense.ExpenseSplitType;

public class ExpenseSplitFactory {
    public static ExpenseSplit getExpenseSplitObject(ExpenseSplitType splitType) {
        switch (splitType) {
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case EQUAL:
                return new EqualExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
