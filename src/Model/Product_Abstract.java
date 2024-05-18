package Model;

interface Product_Abstract {
    String getId();
    String getName();
    int getPrice();

    boolean isAvailable();
    int getStock();

    void setId(String productId);
    void setName(String name);
    void setPrice(int price);
    void setAvailability(boolean availability);
    void setStock(int stock);

}
