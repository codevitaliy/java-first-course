public class FrozenNitrogenProduct extends FrozenProduct {
    private String exposureTime;

    public FrozenNitrogenProduct(String expirationDate, int batchNumber, String packagingDate, String countryOfOrigin,
            int storageTemperature, String exposureTime) {
        super(expirationDate, batchNumber, packagingDate, countryOfOrigin, storageTemperature);
        this.exposureTime = exposureTime;
    }

    @Override
    public String toString() {
        return super.toString() + " exposureTime=" + exposureTime + "]";
    }
}
