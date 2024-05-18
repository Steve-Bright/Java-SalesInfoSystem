package Model;

public class Order implements Order_Abstract{

    private String id;
    private Product product;
    private int qty;

    private int total;

    public Order(String id, Product product, int qty){
        this.id = id;
        this.product = product;
        this.qty = qty;
        this.total = product.getPrice() * qty;
    }
    @Override
    public String getOrderId() {
        return id;
    }

    @Override
    public Product getOrderProduct() {
        return product;
    }

    @Override
    public int getQty() {
        return qty;
    }

    @Override
    public int getTotal() {return total;}
}
