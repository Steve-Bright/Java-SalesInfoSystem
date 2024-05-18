package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AllOrdersRepo {
    private ArrayList<Order> orders = new ArrayList<>();
    public void loadOrders(){
        try{
            AllProductsRepo products =  new AllProductsRepo();
            FileReader ordersSrc = new FileReader("src/Model/orders.csv");
            BufferedReader ordersBr = new BufferedReader(ordersSrc);
            ordersBr.readLine(); //skips the header from the csv file
            String line;
            while((line = ordersBr.readLine()) != null){
                String[] ordersArray = line.split(",");
                String orderId = ordersArray[0];
                String productName = ordersArray[1];
                int qty = Integer.parseInt(ordersArray[3]);

                for(Product eachProduct : products.getProducts()){
                    if(productName.equalsIgnoreCase(eachProduct.getName())){
                        orders.add(new Order(orderId, eachProduct, qty));
                    }
                }

            }
        }
        catch(FileNotFoundException e){
            System.out.println("Admin file not found");
            System.exit(0);
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }
}
