public abstract class Product {
    private String expirationDate;
    private int batchNumber;

    public Product(String expirationDate, int batchNumber) {
        this.expirationDate = expirationDate;
        this.batchNumber = batchNumber;
    }

    @Override
    public String toString() {
        return "Product [expirationDate=" + expirationDate + ", batchNumber=" + batchNumber;
    }
}
