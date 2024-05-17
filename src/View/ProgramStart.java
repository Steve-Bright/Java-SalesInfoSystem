package View;

import java.util.Scanner;
import Model.AllProductsRepo;
import Controller.Products_Controller;

public class ProgramStart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AllProductsRepo products = new AllProductsRepo();
        products.loadProducts();
        Products_Controller productsController = new Products_Controller();

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
                boolean adminResult = false;

                while(!adminResult){ // while admin result is false,
                    adminResult = admin.validateAdmin();
                    if(adminResult)
                        System.out.println("You are admin");
                    else{
                        System.out.println("You are not admin");
                    }
                }
                int value = admin.displayOptions();
                if(value == 1){
                    System.out.println("You click add product info");
                }else if(value == 2){
                    productsController.viewProducts(products.getProducts());
                }else if(value == 3){
                    System.out.println("You click delete product info");
                }else{
                    System.out.println("idk what you entered :)");
                }
                break;

            case 2:
            default:
                System.out.println("Wrong input");

        }
    }
}
