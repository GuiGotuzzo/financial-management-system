package functions.edit;

import database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RevenueEdit {
    private String title;
    private String description;
    private double value;

    public RevenueEdit(String title, String description, double value){
        this.title = title;
        this.description = description;
        this.value = value;
    }

    Scanner scanner = new Scanner(System.in);

    public Map<Integer, Integer> printAndMapTable() {
        String query = "SELECT id,name FROM revenue";

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

    public void update() throws SQLException {
        String sql = "UPDATE revenue SET name = ?, description = ?, revenue = ? WHERE id = ?";

        PreparedStatement ps = null;
        try {
            //Print the tables and create a HashMap
            Map<Integer, Integer> integerIntegerMap = printAndMapTable();

            System.out.println();
            System.out.print("Enter the index to choose: ");
            int selectKey = scanner.nextInt();

            //Check if the key exists in the HashMap
            if(integerIntegerMap.containsKey(selectKey)){
                ps = Database.getConnection().prepareStatement(sql);
                ps.setString(1,this.title);
                ps.setString(2,this.description);
                ps.setDouble(3,this.value);

                //Get the ID
                int selectId = integerIntegerMap.get(selectKey);

                ps.setInt(4,selectId);

                ps.execute();
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
