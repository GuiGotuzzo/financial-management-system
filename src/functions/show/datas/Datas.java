package functions.show.datas;

import database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Datas {
    public void dataRevenue(){
        String query = "SELECT * FROM revenue";

        try (PreparedStatement ps = Database.getConnection().prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()){

            System.out.println();
            System.out.println("Title\t\t\tDescription\t\t\tRevenue");
            System.out.println("-----------------------------------------------");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double value = resultSet.getDouble("revenue");

                System.out.println(name + " -> " + description + " -> " + value);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void dataExpenses(){
        String query = "SELECT * FROM expenses";

        try (PreparedStatement ps = Database.getConnection().prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()){

            System.out.println();
            System.out.println("Title\t\t\tDescription\t\t\tExpense");
            System.out.println("-----------------------------------------------");
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double value = resultSet.getDouble("expense");

                System.out.println(name + " -> " + description + " -> " + value);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
