import functions.add.ControlAdd;
import functions.delete.ControlDelete;
import functions.edit.ControlEdit;
import functions.show.ControlShow;

import java.util.Scanner;

public class Main {

    private static void noneOption(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("None option was typed");
        System.out.println("=============================================");
    }

    public static void main(String[] args){
        System.out.println("Hey!!");
        System.out.println("Welcome to the our Financial Management System :D");
        System.out.println();

        try (Scanner scanner = new Scanner(System.in)){
            boolean a = true;

            while(a){
                System.out.println();
                System.out.println("Options: ");

                System.out.println();

                System.out.println("1 - Add");
                System.out.println("2 - Edit");
                System.out.println("3 - Delete");
                System.out.println("4 - Show");
                System.out.println("5 - Leave");
                System.out.print("-> ");

                int option = scanner.nextInt();

                if(option == 1){ //add
                    ControlAdd controlAdd = new ControlAdd();
                    controlAdd.control();
                }else if(option == 2){ //edit
                    ControlEdit controlEdit = new ControlEdit();
                    controlEdit.control();
                }else if(option == 3){ //delete
                    ControlDelete controlDelete = new ControlDelete();
                    controlDelete.control();
                }else if(option == 4){ //show
                    ControlShow controlShow = new ControlShow();
                    controlShow.control();
                }else if(option == 5) { //Leave
                    a = false;
                }else{
                    noneOption();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}