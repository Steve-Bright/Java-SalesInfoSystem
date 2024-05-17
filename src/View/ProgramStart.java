package View;

import java.io.IOException;
import java.util.Scanner;
import Model.AllProductsRepo;
import Controller.Products_Controller;
import Model.Product;

public class ProgramStart {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AllProductsRepo products = new AllProductsRepo();
        products.loadProducts();
        Products_Controller productsController = new Products_Controller();

        boolean systemRun = true;
        while(systemRun){
            System.out.println("Sales Information System" +
                    "\n......................");
            System.out.print("Admin or Continue the System" +
                    "\n 1. Admin" +
                    "\n 2. Continue" +
                    "\n 3. Exit System" +
                    "\n Your input: ");

            int input = sc.nextInt();
            sc.nextLine();

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
                    boolean adminRun = true;
                    while(adminRun){
                        int value = admin.displayOptions();
                        if(value == 1){
                            boolean productAddAgain = true;
                            while(productAddAgain){
                                System.out.print("Product Id: ");
                                String productId = sc.nextLine();
                                System.out.print("Product Name: ");
                                String productName = sc.nextLine();
                                System.out.print("Product Price: ");
                                int productPrice = sc.nextInt();
                                sc.nextLine();

                                Product product = new Product(productId, productName, productPrice);
                                productsController.addProduct(product, products.getProducts());
                                products.loadProducts();

                                boolean repeatAnother = true;
                                while(repeatAnother){
                                    System.out.print("Add another product? : ");
                                    String ans = sc.nextLine();
                                    if(ans.equalsIgnoreCase("no") || ans.equalsIgnoreCase("n")){
                                        productAddAgain = false;
                                        repeatAnother = false;
                                    }else if(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")){
                                        repeatAnother = false;
                                    }else{
                                        System.out.println("Wrong input? ");
                                    }
                                }
                            }
                        }else if(value == 2){
                            productsController.viewProducts(products.getProducts());
                        }else if(value == 3){
                            boolean productDeleteAgain = true;
                            while(productDeleteAgain){
                                System.out.print("Enter the product id to delete: ");
                                String productId = sc.nextLine();

                                productsController.deleteProduct(productId, products.getProducts());

                                boolean repeatAnother = true;
                                while(repeatAnother){
                                    System.out.print("Delete another item again? :");
                                    String ans = sc.nextLine();
                                    if(ans.equalsIgnoreCase("no") || ans.equalsIgnoreCase("n")){
                                        repeatAnother = false;
                                        productDeleteAgain = false;
                                    }else if(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")){
                                        repeatAnother = false;
                                    }else{
                                        System.out.println("Wrong input?");
                                    }
                                }

                            }
                        }else if(value == 4){
                            adminRun = false;
                        }else{
                            System.out.println("idk what you entered :)");
                        }
                    }
                    break;

                case 2:
                case 3:
                    System.out.println("Program is exiting...");
                    System.exit(0);
                default:
                    System.out.println("Wrong input");

            }
        }


    }
}
