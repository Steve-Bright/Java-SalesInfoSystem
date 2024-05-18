package Model;

interface Order_Abstract {
    String getOrderId();
    Product getOrderProduct();
    int getQty();
    int getTotal();

}
