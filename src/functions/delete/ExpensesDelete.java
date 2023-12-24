package functions.delete;

import database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpensesDelete {

    Scanner scanner = new Scanner(System.in);

    public Map<Integer, Integer> printAndMapTable() {
        String query = "SELECT id,name FROM expenses";

        try (PreparedStatement ps = Database.getConnection().prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {

            Map<Integer, Integer> indexToIdMap = new HashMap<>();
            int index = 1;

            System.out.println();
            System.out.println("Index\tTitle");
            System.out.println("-------------------------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                indexToIdMap.put(index, id);

                System.out.println(index + "  ->   " + name);
                index++;
            }

            return indexToIdMap;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete() throws SQLException{
        String sql = "DELETE FROM expenses WHERE id = ?";

        PreparedStatement ps = null;

        try {
            //Print the tables and create a HashMap
            Map<Integer,Integer> integerIntegerMap = printAndMapTable();

            System.out.println();
            System.out.print("Enter the index to choose: ");
            int selectKey = scanner.nextInt();

            //Check if the key exists in the HashMap
            if(integerIntegerMap.containsKey(selectKey)){
                ps = Database.getConnection().prepareStatement(sql);

                //Get the ID
                int selectId = integerIntegerMap.get(selectKey);

                ps.setInt(1,selectId);

                ps.execute();
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
