import functions.add.ExpensesAdd;
import functions.add.RevenueAdd;
import functions.edit.ExpensesEdit;
import functions.edit.RevenueEdit;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hey!!");
        System.out.println("Welcome to the our Financial Management System :D");
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

            if(option == 1){ //add
                System.out.println();
                System.out.println("Choose: ");
                System.out.println();
                System.out.println("1 - Revenue");
                System.out.println("2 - Expenses");
                System.out.print("-> ");
                option = scanner.nextInt();
                if(option == 1){
                    RevenueAdd revenue = new RevenueAdd("Laptop", "", 35000);
                    revenue.add(); //add a new revenue
                }else if(option == 2){
                    ExpensesAdd expenses = new ExpensesAdd("Impostos", "", 57500);
                    expenses.add(); //add a new expense
                }
            }else if(option == 2){ //edit
                System.out.println();

                System.out.println("Choose: ");
                System.out.println();
                System.out.println("1 - Revenue");
                System.out.println("2 - Expenses");
                System.out.print("-> ");

                option = scanner.nextInt();

                if(option == 1){
                    RevenueEdit revenue = new RevenueEdit("Monitores", "Monitores vendidos", 14700);
                    revenue.update();
                }else if(option == 2){
                    ExpensesEdit expenses = new ExpensesEdit("Benefícios", "", 10000);
                    expenses.update();
                }
            }
        }
    }
}