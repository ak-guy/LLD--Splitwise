package JavaCode.Group;

import java.util.List;
import java.util.ArrayList;
import JavaCode.User.User;
import JavaCode.Expense.Expense;
import JavaCode.Expense.ExpenseController;
import JavaCode.Expense.ExpenseSplitType;
import JavaCode.Expense.Split.Split;

public class Group {
    String groupID;
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;
    ExpenseController expenseController;

    Group(String groupID, String groupName) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupMembers = new ArrayList<>();
        this.expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public List<User> getAllGroupMembers() {
        return this.groupMembers;
    }

    public List<Expense> getAllExpense() {
        return this.expenseList;
    }

    public void addGroupMember(User user) {
        this.groupMembers.add(user);
    }

    public void addExpense(String expenseID, String description, User addedByUser, 
                            double amountPaid, ExpenseSplitType splitType, List<Split> splitDetails) {
        ExpenseController expenseControllerObject = new ExpenseController();           
        Expense expense = expenseControllerObject.creatExpense(expenseID, description, addedByUser, 
                                                            amountPaid, splitType, splitDetails);
        this.expenseList.add(expense);
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
