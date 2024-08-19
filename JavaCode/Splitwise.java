package JavaCode;

import JavaCode.Group.*;
import JavaCode.User.UserController;
import JavaCode.BalanceSheet.UserExpenseBalanceSheetController;
import JavaCode.Expense.ExpenseSplitType;
import JavaCode.User.User;
import JavaCode.Expense.Split.*;
import java.util.*;

public class Splitwise {
    UserController userController;
    GroupController groupController;
    UserExpenseBalanceSheetController userBalanceSheetController;

    Splitwise() {
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.userBalanceSheetController = new UserExpenseBalanceSheetController();
    }

    public void demo() {
        // step 1 : initial setup
        setupUsersAndGroups();

        // step 2 : Adding members to group
        Group group = groupController.searchGroup("G0001");
        group.addGroupMember(userController.getUser("U0002"));
        group.addGroupMember(userController.getUser("U0003"));

        // step 3 : Creating expense for group

        // expense 1
        List<Split> splitDetails = new ArrayList<>();
        Split s1 = new Split(200, userController.getUser("U0001"));
        Split s2 = new Split(200, userController.getUser("U0002"));
        Split s3 = new Split(300, userController.getUser("U0003"));
        splitDetails.add(s1);
        splitDetails.add(s2);
        splitDetails.add(s3);
        group.addExpense("E0001", "Juices", userController.getUser("U0001"), 700, ExpenseSplitType.UNEQUAL, splitDetails);
        // expense 2
        List<Split> splitDetails2 = new ArrayList<>();
        Split sd1 = new Split(200, userController.getUser("U0001"));
        Split sd2 = new Split(200, userController.getUser("U0002"));
        Split sd3 = new Split(200, userController.getUser("U0003"));
        splitDetails2.add(sd1);
        splitDetails2.add(sd2);
        splitDetails2.add(sd3);
        group.addExpense("E0002", "Momos", userController.getUser("U0002"), 600, ExpenseSplitType.EQUAL, splitDetails2);

        // step 4 : checking balancesheet of all user
        for (User user : userController.getAllUsers()) {
            userBalanceSheetController.getUserBalanceSheet(user);
        }
    }

    public void setupUsersAndGroups() {
        addUsersToSplitwise();

        User user1 = userController.getUser("U0001");
        groupController.createGroup("G0001", "Fun Activities", user1);
    }

    public void addUsersToSplitwise() {
        User user1 = new User("U0001", "A1");
        User user2 = new User("U0002", "A2");
        User user3 = new User("U0003", "A3");
        User user4 = new User("U0004", "A4");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);
        userController.addUser(user4);
    }

}
