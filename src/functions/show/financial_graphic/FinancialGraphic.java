package functions.show.financial_graphic;

import database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;


public class FinancialGraphic {
    ArrayList<VariablesToGraphics> revenueArrayList = new ArrayList<>();
    ArrayList<VariablesToGraphics> expenseArrayList = new ArrayList<>();
    public void graphicsRevenue(){
        String query = "SELECT name, revenue FROM revenue";

        try (PreparedStatement ps = Database.getConnection().prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            System.out.println();
            System.out.println("Title\t\t\tRevenue\t\t\tData");
            System.out.println("-----------------------------------------------");

            double totalRevenue = 0;
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double revenue = resultSet.getDouble("revenue");

                VariablesToGraphics revenueData = new VariablesToGraphics();
                revenueData.setTitle(name);
                revenueData.setValue(revenue);

                revenueArrayList.add(revenueData);

                totalRevenue += revenue;
            }

            //Sorting the ArrayList
            revenueArrayList.sort(Comparator.comparingDouble(VariablesToGraphics::getValue).reversed());

            for(int i = 0; i < revenueArrayList.size(); i++){
                double data = (revenueArrayList.get(i).getValue() * 100) / totalRevenue;
                String capitalizeData = String.format("%.2f", data);
                System.out.println(revenueArrayList.get(i).getTitle() + "  ->     " + revenueArrayList.get(i).getValue() + "  ->     " + capitalizeData + "%");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void graphicsExpenses(){
        String query = "SELECT name, expense FROM expenses";

        try (PreparedStatement ps = Database.getConnection().prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            System.out.println();
            System.out.println("Title\t\t\tExpense\t\t\tData");
            System.out.println("-----------------------------------------------");

            double totalExpense = 0;
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double expense = resultSet.getDouble("expense");

                VariablesToGraphics expenseData = new VariablesToGraphics();
                expenseData.setTitle(name);
                expenseData.setValue(expense);

                expenseArrayList.add(expenseData);

                totalExpense += expense;
            }

            //Sorting the ArrayList
            expenseArrayList.sort(Comparator.comparingDouble(VariablesToGraphics::getValue).reversed());

            for(int i = 0; i < expenseArrayList.size(); i++){
                double data = (expenseArrayList.get(i).getValue() * 100) / totalExpense;
                String capitalizeData = String.format("%.2f",data);
                System.out.println(expenseArrayList.get(i).getTitle() + "  ->     " + expenseArrayList.get(i).getValue() + "  ->    " + capitalizeData + "%");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
