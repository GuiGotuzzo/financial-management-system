package functions.delete;

import java.util.Scanner;

public class ControlDelete {
    Scanner scanner = new Scanner(System.in);
    private static void noneOption(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("None option was typed");
        System.out.println("=============================================");
    }

    public void control(){
        boolean a = true;
        while (a) {
            System.out.println();
            System.out.println("Choose: ");
            System.out.println();
            System.out.println("1 - Revenue");
            System.out.println("2 - Expenses");
            System.out.println("3 - Leave");
            System.out.print("-> ");

            int option = scanner.nextInt();

            if (option == 1) {
                RevenueDelete revenue = new RevenueDelete();
                revenue.delete();
                a = false;
            } else if (option == 2) {
                ExpensesDelete expenses = new ExpensesDelete();
                expenses.delete();
                a = false;
            } else if (option == 3) {
                a = false;
            } else {
                noneOption();
            }
        }
    }
}

