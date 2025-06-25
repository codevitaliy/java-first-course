public class Food {
    private String foodName;
    private char foodCode;
    private double foodPrice;

    public Food(String foodName, char foodCode, double foodPrice) {
        this.foodName = foodName;
        this.foodCode = foodCode;
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public char getFoodCode() {
        return foodCode;
    }

    public double getFoodPrice() {
        return foodPrice;
    }
}
