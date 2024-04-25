package program;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

        //--------------------------------------------------------
        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth date(DD/MM/YYYY): ");
        String birthDaySTR = sc.nextLine();
        Date birthDay = sdt.parse(birthDaySTR);

        Client client = new Client(name, email, birthDay);

        //--------------------------------------------------------
        System.out.println("Enter order data:");

        System.out.print("Status: " );
        String orderStatus = sc.nextLine();

        Date moment = new Date();

        Order order = new Order(moment, OrderStatus.PROCESSING, client);

        System.out.print("How many items to this order: ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++){
            System.out.println("Enter #" + (i+1) + " item data:" );

            sc.nextLine();
            System.out.print("Product name: ");
            String productName = sc.nextLine();


            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Product quantity: ");
            int productQuantity = sc.nextInt();

            OrderItem orderItem = new OrderItem(productQuantity, product);

            order.addItem(orderItem);

        }

        //--------------------------------------------------------

        System.out.println(order);

        sc.close();
    }
}
