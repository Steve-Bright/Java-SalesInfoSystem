package Model;

public class Product implements Product_Abstract{
    private int id;
    private String name;
    private int price;

    Product(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public int getId(){
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
