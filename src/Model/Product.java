package Model;

public class Product implements Product_Abstract{
    private String id;
    private String name;
    private int price;
    private boolean isAvailable;
    private int stock;

    public Product(String id, String name, int price, boolean isAvailable, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.stock = stock;;
    }
    @Override
    public String getId(){
        return id;
    };
    @Override
    public String getName(){
        return name;
    };

    @Override
    public int getPrice(){
        return price;
    };

    @Override
    public boolean isAvailable(){ return isAvailable; }

    @Override
    public int getStock(){ return stock; }

    @Override
    public void setId(String productId){
        this.id = productId;
    }
    @Override
    public void setName(String productName){
        this.name = productName;
    }

    @Override
    public void setPrice(int productPrice){
        this.price = productPrice;
    }

    @Override
    public void setAvailability(boolean availability){
        this.isAvailable = availability;
    };

    @Override
    public void setStock(int stock){
        this.stock = stock;
    }

}
