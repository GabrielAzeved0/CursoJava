import entities.ImportProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++){
            System.out.println("Product #" + (i+1) + " data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            String typeProduct = sc.next();

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (Objects.equals(typeProduct, "c")){
                products.add(new Product(name, price));
            }

            else if (Objects.equals(typeProduct, "i")){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();

                products.add(new UsedProduct(name, price, customsFee));
            }

            else if (Objects.equals(typeProduct, "u")) {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = sc.next();
                Date manufacturedDate = sdf.parse(dateStr);

                products.add(new ImportProduct(name, price, manufacturedDate));
            }
        }

        for (Product p : products){
            System.out.println(p.priceTag());
        }





        sc.close();
    }
}