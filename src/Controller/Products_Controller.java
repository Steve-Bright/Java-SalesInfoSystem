package Controller;


import Model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Products_Controller implements Products_Controller_Interface{

    @Override
    public void viewProducts(ArrayList<Product> products){
        System.out.println("Product Detail");
        System.out.printf("----------------------------------------------------------%n");
        System.out.printf("| %-11s | %-25s | %-12s | %n", "Product Id", "Product Name", "Price");
        System.out.printf("----------------------------------------------------------%n");
        for(Product product: products){
            System.out.printf("| %-11s | %-25s | %12s |%n",product.getId(),product.getName(), product.getPrice());
        }
    }

    @Override
    public void addProduct(Product product, ArrayList<Product> products) throws IOException {
        String filePath = "src/Model/products.csv";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
        String productId = product.getId();
        String productName = product.getName();
        int productPrice = product.getPrice();
        bw.newLine();
        bw.write(productId+ ","+ productName +","+productPrice);

        bw.close();
    }

    @Override
    public void deleteProduct(String productId, ArrayList<Product> products) throws IOException {
        boolean idFound = false;
        for(Product eachProduct: products){
            if(eachProduct.getId().equalsIgnoreCase(productId)){
                products.remove(eachProduct);
                reloadProducts(products);
                idFound = true;
                break;
            }
        }
        if(!idFound){
            System.out.println("Id not found!");
        }


    }
    private void reloadProducts(ArrayList<Product> products) throws IOException {
        String filePath = "src/Model/products.csv";
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write("Name,Item,Price");
        bw.newLine();

        for(Product eachProduct: products){
            bw.write(eachProduct.getId()+","+eachProduct.getName()+","+eachProduct.getPrice());
            bw.newLine();
        }
        bw.close();
        System.out.println("Product Deleted! ");
    }
}
