package functions.add;

import database.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RevenueAdd {

    private String title;
    private String description;
    private double value;

    public RevenueAdd(String title, String description, double value){
        this.title = title;
        this.description = description;
        this.value = value;
    }
    public void add(){
        String sql = "INSERT INTO revenue(name, description, revenue) VALUES(?, ?, ?)";

        PreparedStatement ps;

        try {
            ps = Database.getConnection().prepareStatement(sql);
            ps.setString(1,this.title);
            ps.setString(2,this.description);
            ps.setDouble(3,this.value);

            ps.execute();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
