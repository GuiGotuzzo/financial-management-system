package functions.show.balance;

import database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Balance {
    String queryRevenue = "SELECT revenue FROM revenue";
    String queryExpense = "SELECT expense FROM expenses";

    public void balance() throws SQLException {
        PreparedStatement psRevenue = Database.getConnection().prepareStatement(queryRevenue);
        ResultSet resultSetRevenue = psRevenue.executeQuery();

        double revenue = 0;
        while (resultSetRevenue.next()){
            revenue += resultSetRevenue.getDouble("revenue");
        }

        PreparedStatement psExpense = Database.getConnection().prepareStatement(queryExpense);
        ResultSet resultSetExpense = psExpense.executeQuery();

        double expense = 0;
        while (resultSetExpense.next()){
            expense += resultSetExpense.getDouble("expense");
        }

        double totalBalance = revenue - expense;

        System.out.println();
        System.out.println("Revenue: " + revenue);
        System.out.println("Expense: " + expense);
        System.out.println();
        System.out.println("Total balance: " + totalBalance);
    }
}
