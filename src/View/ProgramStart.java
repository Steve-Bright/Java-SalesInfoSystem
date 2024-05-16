package View;

import java.util.Scanner;

public class ProgramStart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Sales Information System" +
                "\n ......................");
        System.out.print("Admin or Continue the System" +
                "\n 1. Admin" +
                "\n 2. Continue" +
                "\n Your input: ");

        int input = sc.nextInt();

        switch(input){
            case 1:
                AdminPanel admin = new AdminPanel();
                int adminResult = admin.validateAdmin();
                if(adminResult == 1)
                    System.out.println("You are admin");
                else if(adminResult == 0)
                    System.out.println("You are not admin");
                else{
                    System.out.println("Something went wrong");
                }
                break;
            default:
                System.out.println("Wrong input");

        }
    }
}
