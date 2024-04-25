package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Client client;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;

    private List<OrderItem> listItems = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nORDER SUMMARY:\n");
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + '\n');
        sb.append("Order Status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client.getName() + " ");
        sb.append("(" + sdf.format(client.getBirthDate()) + ") - ");
        sb.append(client.getEmail() + "\n");
        sb.append("Order items: \n");
        for (OrderItem item : listItems){
            sb.append(item.getName() + ", $");
            sb.append(item.getPrice() + ", ");
            sb.append("Quantity: ");
            sb.append(item.getQuantity() + ", ");
            sb.append("Subtotal: $");
            sb.append(item.subTotal() + "\n");
        }
        sb.append("Total price: $");
        sb.append(total());
        return sb.toString();
    }

    public void addItem(OrderItem item){
        listItems.add(item);
    }

    public void removeItem(OrderItem item){
        listItems.remove(item);
    }

    public Double total(){
        Double sum = 0.0;

        for (OrderItem item : listItems){
            sum += item.subTotal();
        }

        return sum;
    }





}
