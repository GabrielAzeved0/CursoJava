package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();

        String pathStr = sc.nextLine();
        File pathFonte = new File(pathStr);

        try (BufferedReader br = new BufferedReader(new FileReader((pathFonte)))){
            String line = br.readLine();

            while (line != null){

                String name = line.split(",")[0];
                double price = Double.valueOf(line.split(",")[1]);
                int quantity = Integer.valueOf(line.split(",")[2]);

                productList.add(new Product(name, price, quantity));

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        new File(pathFonte.getParent() + "\\out").mkdir();
        File pathDestiny = new File(pathFonte.getParent() + "\\out");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDestiny + "\\summary.csv"))){

            for (Product p : productList){
                String line = p.name + "," + p.total();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            sc.close();
            System.out.println("Sucess");
        }


    }
}
