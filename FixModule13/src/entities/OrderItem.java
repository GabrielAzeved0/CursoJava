package entities;

public class OrderItem {

    private Integer quantity;
    private String name;
    private Double price;
            ;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        name = product.getName();
        price = product.getPrice();

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double subTotal(){
        return quantity * price;
    }

}
