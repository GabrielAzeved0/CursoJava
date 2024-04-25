package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportProduct extends Product{

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date manufacteredDate;

    public ImportProduct() {
        super();
    }

    public ImportProduct(String name, Double price, Date manufacteredDate) {
        super(name, price);
        this.manufacteredDate = manufacteredDate;
    }

    public Date getManufacteredDate() {
        return manufacteredDate;
    }

    public void setManufacteredDate(Date manufacteredDate) {
        this.manufacteredDate = manufacteredDate;
    }

    @Override
    public String priceTag(){
        return name + " (used) " +
                "$" + String.format("%.2f", price) +
                 " (Manufacture date: " + sdf.format(manufacteredDate) + ")";
    }
}
