public class Product {
    private String code;    // product code or name
    private double price;   // unit price
    private int count;      // stock quantity

    public Product(String code, double price, int count) {
        this.code  = code;
        this.price = price;
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // formatted display of product details
    @Override
    public String toString() {
        return String.format("%s | $%.2f | qty: %d", code, price, count);
    }
}
