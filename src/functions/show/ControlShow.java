package functions.show;

import functions.show.balance.Balance;
import functions.show.datas.Datas;
import functions.show.financial_graphic.FinancialGraphic;

import java.sql.SQLException;
import java.util.Scanner;

public class ControlShow {
    Scanner scanner = new Scanner(System.in);

    private static void noneOption(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("None option was typed");
        System.out.println("=============================================");
    }
    public void control() throws SQLException {
        boolean a = true;
        while (a) {
            System.out.println();
            System.out.println("Choose: ");
            System.out.println();
            System.out.println("1 - Datas");
            System.out.println("2 - Financial graphic");
            System.out.println("3 - Total balance");
            System.out.println("4 - Leave");
            System.out.print("-> ");

            int option = scanner.nextInt();

            if(option == 1){
                boolean b = true;

                while (b){
                    System.out.println();

                    System.out.println("Choose: ");
                    System.out.println();
                    System.out.println("1 - Revenue");
                    System.out.println("2 - Expenses");
                    System.out.println("3 - Leave");
                    System.out.print("-> ");

                    option = scanner.nextInt();

                    Datas datas = new Datas();
                    if(option == 1){
                        datas.dataRevenue();
                        b = false;
                    }else if(option == 2){
                        datas.dataExpenses();
                        b = false;
                    }else if(option == 3){
                        b = false;
                    }else{
                        noneOption();
                    }
                }
            }else if(option == 2){
                boolean b = true;

                while (b) {
                    System.out.println();

                    System.out.println("Choose: ");
                    System.out.println();
                    System.out.println("1 - Revenue");
                    System.out.println("2 - Expenses");
                    System.out.println("3 - Leave");
                    System.out.print("-> ");

                    option = scanner.nextInt();

                    FinancialGraphic financialGraphic = new FinancialGraphic();
                    if(option == 1){
                        financialGraphic.graphicsRevenue();
                        b = false;
                    }else if(option == 2){
                        financialGraphic.graphicsExpenses();
                        b = false;
                    }else if(option == 3){
                        b = false;
                    }else{
                        noneOption();
                    }
                }
            }else if(option == 3){
                Balance balance = new Balance();
                balance.balance();
            }else if(option == 4){
                a = false;
            }else{
                noneOption();
            }
        }
    }
}
