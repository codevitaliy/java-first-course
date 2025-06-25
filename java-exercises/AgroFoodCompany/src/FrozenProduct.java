public abstract class FrozenProduct extends Product {
    private String packagingDate;
    private String countryOfOrigin;
    private int storageTemperature;

    public FrozenProduct(String expirationDate, int batchNumber, String packagingDate, String countryOfOrigin,
            int storageTemperature) {
        super(expirationDate, batchNumber);
        this.packagingDate = packagingDate;
        this.countryOfOrigin = countryOfOrigin;
        this.storageTemperature = storageTemperature;
    }

    @Override
    public String toString() {
        return super.toString() + " packagingDate=" + packagingDate + ", countryOfOrigin=" + countryOfOrigin
                + ", storageTemperature=" + storageTemperature;
    }
}
