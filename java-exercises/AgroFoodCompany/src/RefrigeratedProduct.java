public class RefrigeratedProduct extends Product {
    private int organizationCode;
    private String packagingDate;
    private int recommendedTemperature;
    private String countryOfOrigin;

    public RefrigeratedProduct(String expirationDate, int batchNumber, int organizationCode, String packagingDate,
            int recommendedTemperature, String countryOfOrigin) {
        super(expirationDate, batchNumber);
        this.organizationCode = organizationCode;
        this.packagingDate = packagingDate;
        this.recommendedTemperature = recommendedTemperature;
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return super.toString() + " organizationCode=" + organizationCode + ", packagingDate=" + packagingDate
                + ", recommendedTemperature=" + recommendedTemperature + ", countryOfOrigin=" + countryOfOrigin + "]";
    }
}
