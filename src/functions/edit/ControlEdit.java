package functions.edit;

import database.Database;

import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Scanner;

public class ControlEdit {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);

    private static void noneOption(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("None option was typed");
        System.out.println("=============================================");
    }

    public void control(){
        boolean a = true;
        int option;

        while (a) {
            System.out.println();
            System.out.println("Choose: ");
            System.out.println();
            System.out.println("1 - Revenue");
            System.out.println("2 - Expenses");
            System.out.println("3 - Leave");
            System.out.print("-> ");

            option = scanner.nextInt();

            try {
                if (option == 1 || option == 2) {
                    String sql;

                    //Print the tables and create a HashMap
                    Map<Integer, Integer> integerIntegerMap;
                    if(option == 1){
                        sql = "UPDATE revenue description = ?, revenue = ? WHERE id = ?";

                        RevenueEdit revenueEdit = new RevenueEdit();
                        integerIntegerMap = revenueEdit.printAndMapTable();
                    }else{
                        sql = "UPDATE expenses description = ?, expense = ? WHERE id = ?";

                        ExpensesEdit expensesEdit = new ExpensesEdit();
                        integerIntegerMap = expensesEdit.printAndMapTable();
                    }

                    boolean b = true;
                    int selectKey = 0;
                    while (b){
                        System.out.println();
                        System.out.print("Enter the index to choose: ");
                        selectKey = scanner.nextInt();

                        //Check if the key exists in the HashMap
                        if(integerIntegerMap.containsKey(selectKey)){
                           b = false;
                        }else{
                            System.out.println();
                            System.out.println("=============================================");
                            System.out.println("The key typed isn't in the list");
                            System.out.println("=============================================");
                        }
                    }

                    System.out.println();
                    System.out.print("Description (optional): ");
                    String description = scannerString.nextLine();

                    b = true;
                    double value = 0;
                    while (b) {
                        System.out.print("Value: ");
                        value = scanner.nextDouble();

                        if (value < 0) {
                            System.out.println();
                            System.out.println("=============================================");
                            System.out.println("The value can't be less than 0");
                            System.out.println("=============================================");
                            System.out.println();
                        } else {
                            b = false;
                        }
                    }
                    PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                    ps.setString(1, description);
                    ps.setDouble(2, value);

                    // Get the ID
                    int selectId = integerIntegerMap.get(selectKey);

                    ps.setInt(3, selectId);

                    ps.execute();
                    ps.close();

                    a = false;
                } else if (option == 3) {
                    a = false;
                } else {
                    noneOption();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}