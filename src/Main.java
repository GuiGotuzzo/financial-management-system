import functions.add.Expenses;
import functions.add.Revenue;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hey!!");
        System.out.println("Welcome to the our Financial Management System :D");

        System.out.println();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);
        boolean a = true;

        while(a){
            System.out.println();
            System.out.println("Options: ");

            System.out.println();

            System.out.println("1 - Add");
            System.out.println("2 - Edit");
            System.out.println("3 - Delete");
            System.out.println("4 - Show");
            System.out.print("-> ");

            int option = scanner.nextInt();

            if(option == 1){
                System.out.println();
                System.out.println("1 - Revenue");
                System.out.println("2 - Expenses");
                System.out.print("-> ");
                option = scanner.nextInt();
                if(option == 1){
                    System.out.println();

                    System.out.print("Title: ");
                    String title = scannerString.nextLine();

                    System.out.print("Description: ");
                    String description = scannerString.nextLine();

                    System.out.print("Revenue: ");
                    double value = scanner.nextDouble();
                    Revenue revenue = new Revenue(title,description,value);
                    revenue.add(); //add a new revenue
                }else if(option == 2){
                    System.out.println();

                    System.out.print("Title: ");
                    String title = scannerString.nextLine();

                    System.out.print("Description: ");
                    String description = scannerString.nextLine();

                    System.out.print("Expense: ");
                    double value = scanner.nextDouble();
                    Expenses expenses = new Expenses(title,description,value);
                    expenses.add(); //add a new expense
                }
            }
        }
    }
}