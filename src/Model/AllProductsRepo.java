package Model;

import Model.User.Admin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AllProductsRepo {
    private ArrayList<Product> products = new ArrayList<>();

    public void loadProducts(){
        products.clear();
        try{
            FileReader productsSrc = new FileReader("src/Model/products.csv");
            BufferedReader productBr = new BufferedReader(productsSrc);
            productBr.readLine(); //skips the header from the csv file
            String line;
            while((line = productBr.readLine()) != null){
                String[] productsArray = line.split(",");
                int price = Integer.parseInt(productsArray[2]);
                boolean isAvailable = Boolean.parseBoolean(productsArray[3]);
                int stock = Integer.parseInt(productsArray[4]);
                products.add(new Product(productsArray[0], productsArray[1], price, isAvailable, stock));
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

    public ArrayList<Product> getProducts(){
        return products;
    }
}
