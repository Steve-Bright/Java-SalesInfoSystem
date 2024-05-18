package View;

import Controller.Orders_Controller;
import Controller.Products_Controller;
import  Model.User.AllUsersRepo;
import Model.Product;
import Model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientSystem implements ClientSystem_Interface{
    @Override
    public boolean validateUser(){
        AllUsersRepo usersPool = new AllUsersRepo();
        usersPool.loadData();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the username: ");
        String username = sc.nextLine();
        System.out.print("Enter the password: ");
        String password = sc.nextLine();

        for(int i = 0; i < usersPool.getUsers().size(); i++){
            String userAccName = usersPool.getUsers().get(i).getName();
            String userAccPassword = usersPool.getUsers().get(i).getPassword();
            if(username.equals(userAccName) && password.equals(userAccPassword)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void showAvailableProducts(ArrayList<Product> products){
        System.out.println("Products you can get now!");
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-11s | %-25s | %-12s |%n", "Product Id", "Product Name", "Price");
        System.out.printf("-----------------------------------------------------------------------------------%n");
        for(Product product: products){
            if(product.isAvailable()){
                System.out.printf("| %-11s | %-25s | %-12s | %n",product.getId(),product.getName(), product.getPrice());
            }
        }
    }

    @Override
    public int displayOptions(){
        Scanner sc = new Scanner(System.in);
        System.out.print("1. View a specific Item" +
                "\n2. Sort Products" +
                "\n3. Search a Product" +
                "\n4. Buy a Product" +
                "\n5. Order History" +
                "\n6. Exit" +
                "\n Your Input: ");
        return sc.nextInt();

    }

    @Override
    public void viewItemOption(ArrayList<Product> products, ArrayList<Order> orders) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean product = false;
        while(product == false){
            System.out.print("Enter the product id or name to view details on: ");
            String viewInput = sc.nextLine();

            for(Product eachProduct : products){
                if(viewInput.equalsIgnoreCase(eachProduct.getName()) || viewInput.equals(eachProduct.getId())){
                    System.out.println("Viewing Product Details");
                    System.out.println("Product Id: "+ eachProduct.getId());
                    System.out.println("Product Name: "+ eachProduct.getName());
                    System.out.println("Product Price: "+ eachProduct.getPrice());

                    System.out.print("Buy or nah: ");
                    String buyItem = sc.nextLine();
                    if(buyItem.equalsIgnoreCase("yes")|| buyItem.equalsIgnoreCase("y")){
                        buyItem(eachProduct, products, orders);
                        product = true;
                        break;
                    } else if (buyItem.equalsIgnoreCase("no") || buyItem.equalsIgnoreCase("n")) {
                        product = true;
                        break;
                    }
                }
            }
        }

    }

    void buyItem(Product product, ArrayList<Product> products, ArrayList<Order> orders) throws IOException {
        Orders_Controller ordersController = new Orders_Controller();
        Products_Controller productsController =  new Products_Controller();
        Scanner sc = new Scanner(System.in);
        boolean inStock = true;
        while(inStock){
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            if(qty <= product.getStock()){
                inStock = false;
                String orderId = "o"+ ((int) (Math.random() * 999999) + 1);
                Order newOrder = new Order(orderId, product, qty);

                productsController.updateStock(qty, product, products);
                ordersController.addOrder(newOrder, orders);
                System.out.println("Product bought!");
                ordersController.viewAnOrder(newOrder);
            }else{
                System.out.println("We only have " + product.getStock() + " stocks left!");
            }
        }



    }

    @Override
    public void displayOrders(ArrayList<Order> orders){
        System.out.println("Products you can get now!");
        System.out.printf("-----------------------------------------------------------------------------------%n");
        System.out.printf("| %-11s | %-25s | %-12s| %-12s | %-12s |%n", "Order Id", "Product Name", "Price", "Quantity", "Total");
        System.out.printf("-----------------------------------------------------------------------------------%n");

        for(Order order: orders){
            System.out.printf("| %-11s | %-25s | %-12s |%-12s | %-12s| %n",order.getOrderId(), order.getOrderProduct().getName(), order.getOrderProduct().getPrice(), order.getQty(), order.getTotal());
        }
    }

}
