package View;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import Model.AllOrdersRepo;
import Model.AllProductsRepo;
import Controller.Products_Controller;
import Model.Product;

public class ProgramStart {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AllProductsRepo products = new AllProductsRepo();
        AllOrdersRepo orders = new AllOrdersRepo();
        products.loadProducts();
        Products_Controller productsController = new Products_Controller();

        try{
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
                        //ADMIN

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
                                    System.out.print("Product Stock: ");
                                    int stock = sc.nextInt();
                                    sc.nextLine();


                                    Product product = new Product(productId, productName, productPrice, true, stock);
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
                                boolean viewProducts = true;
                                while(viewProducts){
                                    productsController.viewProducts(products.getProducts());
                                    System.out.print("1. Sort the products by price: " +
                                            "\n2. Sort the products by stock" +
                                            "\n3. Search a product" +
                                            "\n4. Return" +
                                            "\n Input: ");
                                    int adminViewResponse = sc.nextInt();
                                    sc.nextLine();

                                    switch (adminViewResponse){
                                        case 1:
                                            System.out.print("Ascending: ");
                                            boolean ascendingPrice = sc.nextBoolean();
                                            productsController.viewProducts(productsController.sortProductsPrice(products.getProducts(), ascendingPrice));
                                            break;
                                        case 2:
                                            System.out.print("Ascending: ");
                                            boolean ascendingStock = sc.nextBoolean();
                                            productsController.viewProducts(productsController.sortProductsStock(products.getProducts(), ascendingStock));
                                            break;
                                        case 3:
                                            System.out.print("Enter the product id or String: ");
                                            String searchValue = sc.nextLine();
                                            int searchResult = productsController.searchProduct(searchValue, products.getProducts());
                                            if( searchResult != -1){
                                                String productId = products.getProducts().get(searchResult).getId();
                                                String productName = products.getProducts().get(searchResult).getName();
                                                int productPrice = products.getProducts().get(searchResult).getPrice();
                                                boolean productAvailability = products.getProducts().get(searchResult).isAvailable();
                                                int productStock = products.getProducts().get(searchResult).getStock();
                                                System.out.println("Product Found!");
                                                System.out.printf("Product Id: %s \nProduct Name: %s \nProduct Price: %s " +
                                                        "\nAvailability: %s \nStock %s %n", productId, productName, productPrice, productAvailability, productStock);
                                            }else{
                                                System.out.println("Product not Found!");
                                            }
                                            break;
                                        case 4:
                                            viewProducts = false;
                                            break;
                                        default:
                                            System.out.println("Wrong input? ");
                                    }
                                }

                            }else if(value == 3){
                                boolean productEditAgain = true;
                                while(productEditAgain) {
                                    System.out.print("Enter the product id to edit: ");
                                    String productId = sc.nextLine();

                                    productsController.editProduct(productId, products.getProducts());

                                    boolean repeatAnother = true;
                                    while (repeatAnother) {
                                        System.out.print("Edit another item again? :");
                                        String ans = sc.nextLine();
                                        if (ans.equalsIgnoreCase("no") || ans.equalsIgnoreCase("n")) {
                                            repeatAnother = false;
                                            productEditAgain = false;
                                        } else if (ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) {
                                            repeatAnother = false;
                                        } else {
                                            System.out.println("Wrong input?");
                                        }
                                    }
                                }
                            } else if(value == 4){
                                boolean productDeleteAgain = true;
                                while(productDeleteAgain){
                                    System.out.print("Enter the product id to delete: ");
                                    String productId = sc.nextLine();

                                    productsController.deleteProduct(productId, products.getProducts());

                                    boolean repeatAnother = true;
                                    while(repeatAnother){
                                        System.out.print("Edit another item again? :");
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
                            }else if(value == 5){
                                adminRun = false;
                            }else{
                                System.out.println("idk what you entered :)");
                            }
                        }
                        break;

                    case 2:
                        ClientSystem client = new ClientSystem();
                        boolean userAcc = false;
                        boolean validAcc = false;

                        boolean userAccQuestion = true;
                        while(userAccQuestion){
                            System.out.print("Do you have user account? :");
                            String ans = sc.nextLine();

                            if(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")){
                                while(!validAcc){
                                    boolean result = client.validateUser();
                                    if (result){
                                        userAcc = true;
                                        orders.loadOrders();
                                        System.out.println("User is logged in!");
                                        validAcc = true;
                                    }else{
                                        System.out.println("Wrong username or password");
                                    }
                                }
                                userAccQuestion = false;
                            }else if(ans.equalsIgnoreCase("no") || ans.equalsIgnoreCase("n")){
                                System.out.println("Logged in as guest user! You can view the item but not buy them!");
                                userAccQuestion = false;
                            }else{
                                System.out.println("wrong input?");
                            }
                        }

                        boolean clientSystem = true;
                        while(clientSystem){
                            products.loadProducts();
                            client.showAvailableProducts(products.getProducts());
                            int userInput = client.displayOptions();
                            if(userInput == 1){
                                client.viewItemOption(products.getProducts(), orders.getOrders());
                            }else if(userInput == 2){
                                client.showAvailableProducts(productsController.sortProductsPrice(products.getProducts(), false));
//                            productsController.viewProducts(productsController.sortProductsStock(products.getProducts()));

//                      //client sort
                            }else if(userInput == 3){
                                boolean productFound = false;
                                while(!productFound){
                                    System.out.print("Enter product Item id or name you want to buy: ");
                                    String item = sc.nextLine();
                                    for(Product product: products.getProducts()){
                                        if(product.getId().equals(item) || product.getName().equals(item)){
                                            client.buyItem(product, products.getProducts(), orders.getOrders());
                                            productFound = true;
                                            break;
                                        }
                                    }
                                }
                            }else if(userInput == 4){
                                if(userAcc){
                                    client.displayOrders(orders.getOrders());
                                }else{
                                    while(!validAcc){
                                        boolean result = client.validateUser();
                                        if (result){
                                            userAcc = true;
                                            orders.loadOrders();
                                            System.out.println("User is logged in!");
                                            client.displayOrders(orders.getOrders());
                                            validAcc = true;
                                        }else{
                                            System.out.println("Wrong username or password");
                                        }
                                    }
                                }
                            }else if(userInput == 5){
                                clientSystem = false;
                            }else{
                                System.out.println("Wrong input");
                            }
                        }
                        //view , sort or search
                        //if view --> detail product
                        //in detail, choose buy -> how much
                        //check stock, buy
                        //if user already logged in, no steps further,

                        break;
                    case 3:
                        System.out.println("Program is exiting...");
                        systemRun = false;

                    default:
                        System.out.println("Wrong input");

                }
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input! System exiting");
        }


    }
}
