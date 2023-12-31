package functions.edit;

import database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RevenueEdit {

    protected Map<Integer, Integer> printAndMapTable() {
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
}
