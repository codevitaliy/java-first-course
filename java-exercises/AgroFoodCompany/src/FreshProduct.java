public class FreshProduct extends Product {
    private String packagingDate;
    private String countryOfOrigin;

    public FreshProduct(String expirationDate, int batchNumber, String packagingDate, String countryOfOrigin) {
        super(expirationDate, batchNumber);
        this.packagingDate = packagingDate;
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return super.toString() + " packagingDate=" + packagingDate + ", countryOfOrigin=" + countryOfOrigin + "]";
    }
}
