public class Drink {
    
    private String drinkName;
    private char drinkCode;
    private double drinkPrice;

    public Drink(String drinkName, char drinkCode, double drinkPrice) {
        this.drinkName = drinkName;
        this.drinkCode = drinkCode;
        this.drinkPrice = drinkPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public char getDrinkCode() {
        return drinkCode;
    }

    public double getDrinkPrice() {
        return drinkPrice;
    }
}
