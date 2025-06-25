public class FrozenAirProduct extends FrozenProduct {
    private int nitrogenPercentage;
    private int oxygenPercentage;
    private int carbonDioxidePercentage;
    private int waterVaporPercentage;

    public FrozenAirProduct(String expirationDate, int batchNumber, String packagingDate, String countryOfOrigin,
            int storageTemperature, int nitrogenPercentage, int oxygenPercentage, int carbonDioxidePercentage,
            int waterVaporPercentage) {
        super(expirationDate, batchNumber, packagingDate, countryOfOrigin, storageTemperature);
        this.nitrogenPercentage = nitrogenPercentage;
        this.oxygenPercentage = oxygenPercentage;
        this.carbonDioxidePercentage = carbonDioxidePercentage;
        this.waterVaporPercentage = waterVaporPercentage;
    }

    @Override
    public String toString() {
        return super.toString() + " nitrogen=" + nitrogenPercentage + "%, oxygen=" + oxygenPercentage
                + "%, carbonDioxide=" + carbonDioxidePercentage + "%, waterVapor=" + waterVaporPercentage + "%]";
    }
}
