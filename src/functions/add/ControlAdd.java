package functions.add;

import java.util.Scanner;

public class ControlAdd {
    private static void nothingTyped(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("You didn't type nothing!");
        System.out.println("Please,choose an option!");
        System.out.println("=============================================");
    }

    private static void noneOption(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("None option was typed");
        System.out.println("=============================================");
    }

    Scanner scanner = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);
    public void control(){
        boolean a = true;

        while(a) {
            System.out.println();
            System.out.println("Choose: ");
            System.out.println();
            System.out.println("1 - Revenue");
            System.out.println("2 - Expenses");
            System.out.println("3 - Leave");
            System.out.print("-> ");

            int option = scanner.nextInt();

            if (option == 1 || option == 2) {
                String title = null;
                double value = 0;

                boolean b = true;
                while (b) {
                    System.out.println();
                    System.out.print("Title: ");
                    title = scannerString.nextLine();

                    if (!title.isEmpty()) {
                        b = false;
                    } else {
                        nothingTyped();
                        System.out.println();
                    }
                }
                System.out.print("Description (optional): ");
                String description = scannerString.nextLine();

                b = true;
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

                if (option == 1) {
                    RevenueAdd revenue = new RevenueAdd(title, description, value);
                    revenue.add(); //add a new revenue
                }else{
                    ExpensesAdd expenses = new ExpensesAdd(title, description, value);
                    expenses.add(); //add a new expense
                }

                a = false;
            } else if (option == 3) {
                a = false;
            } else {
                noneOption();
            }
        }
    }
}