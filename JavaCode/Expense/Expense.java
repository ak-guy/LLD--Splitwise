package JavaCode.Expense;

import java.util.ArrayList;
import java.util.List;
import JavaCode.Expense.Split.Split;
import JavaCode.User.User;

/*
 * class to maintain an Expense belonging to a List of Users ie.., splitDetails
 * added by a user ie.., paidByUser
 */

public class Expense {
    String expenseID;
    String description;
    User addedByUser;
    double amountPaid;
    ExpenseSplitType splitType;
    List<Split> splitDetails = new ArrayList<>();

    public Expense(){};

    public Expense(String expenseID, String description, User addedByUser, double amountPaid, ExpenseSplitType splitType,
            List<Split> splitDetails) {
        this.expenseID = expenseID;
        this.description = description;
        this.addedByUser = addedByUser;
        this.amountPaid = amountPaid;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }
}
