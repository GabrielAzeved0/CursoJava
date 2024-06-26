package entities;

public class UsedProduct extends Product{

    private Double customsFee;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public Double totalPrice(){
        return price + customsFee;
    }

    @Override
    public String priceTag(){
        return name +
                " $" + totalPrice() +
                " (Customs fee: $" + String.format("%.2f", customsFee) + ")";
    }

}
