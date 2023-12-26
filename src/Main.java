import functions.add.ExpensesAdd;
import functions.add.RevenueAdd;
import functions.delete.ExpensesDelete;
import functions.delete.RevenueDelete;
import functions.edit.ExpensesEdit;
import functions.edit.RevenueEdit;
import functions.show.datas.Datas;
import functions.show.financial_graphic.FinancialGraphic;

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
                    RevenueEdit revenue = new RevenueEdit("Monitores", "", 14700);
                    revenue.update();
                }else if(option == 2){
                    ExpensesEdit expenses = new ExpensesEdit("Benefícios", "", 10000);
                    expenses.update();
                }
            }else if(option == 3){ //delete
                System.out.println();

                System.out.println("Choose: ");
                System.out.println();
                System.out.println("1 - Revenue");
                System.out.println("2 - Expenses");
                System.out.print("-> ");

                option = scanner.nextInt();

                if(option == 1){
                    RevenueDelete revenue = new RevenueDelete();
                    revenue.delete();
                }else if(option == 2){
                    ExpensesDelete expenses = new ExpensesDelete();
                    expenses.delete();
                }
            }else if(option == 4){ //show
                System.out.println();

                System.out.println("Choose: ");
                System.out.println();
                System.out.println("1 - Datas");
                System.out.println("2 - Financial graphic");
                System.out.print("-> ");

                option = scanner.nextInt();
                if(option == 1){

                    System.out.println("Choose: ");
                    System.out.println();
                    System.out.println("1 - Revenue");
                    System.out.println("2 - Expenses");
                    System.out.print("-> ");

                    option = scanner.nextInt();

                    Datas datas = new Datas();
                    if(option == 1){
                        datas.dataRevenue();
                    }else if(option == 2){
                        datas.dataExpenses();
                    }
                }else if(option == 2){
                    System.out.println("Choose: ");
                    System.out.println();
                    System.out.println("1 - Revenue");
                    System.out.println("2 - Expenses");
                    System.out.print("-> ");

                    option = scanner.nextInt();

                    FinancialGraphic graphics = new FinancialGraphic();
                    if(option == 1){
                        graphics.graphicsRevenue();
                    }else if(option == 2){
                        graphics.graphicsExpenses();
                    }
                }
            }
        }
    }
}