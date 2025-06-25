public class FrozenWaterProduct extends FrozenProduct {
    private int saltGrams;
    private int waterLiters;

    public FrozenWaterProduct(String expirationDate, int batchNumber, String packagingDate, String countryOfOrigin,
            int storageTemperature, int saltGrams, int waterLiters) {
        super(expirationDate, batchNumber, packagingDate, countryOfOrigin, storageTemperature);
        this.saltGrams = saltGrams;
        this.waterLiters = waterLiters;
    }

    private int waterSalinity() {
        return saltGrams * waterLiters;
    }

    @Override
    public String toString() {
        return super.toString() + " saltGrams=" + saltGrams + ", waterLiters=" + waterLiters
                + " → total salinity = " + waterSalinity() + "]";
    }
}
