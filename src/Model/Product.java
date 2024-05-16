package Model;

public class Product implements Product_Abstract{
    private String id;
    private String name;
    private int price;

    Product(String id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
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
}
