package Controller;


import Model.Product;
import Model.AllProductsRepo;

public class Products_Controller implements Products_Controller_Interface{
    AllProductsRepo products = new AllProductsRepo();

    @Override
    public void viewProducts(){
        products.loadProducts();
        for(Product product: products.getProducts()){
            System.out.println(product);
        }
    }

    @Override
    public void addProduct(Product product){

    }

    @Override
    public void deleteProduct(Product product){

    }
}
