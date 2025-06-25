import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MainVendingMachine {
    public static ArrayList<Food> foodList = new ArrayList<>();
    public static ArrayList<Drink> drinkList = new ArrayList<>();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        addFood();
        addDrink();
        menu();
    }

    private static void menu() {
        int mainSelection = 0;
        int subSelection = 0;
        boolean exit = false;

        do {
            System.out.println("1) Buy food");
            System.out.println("2) Buy drink");
            System.out.println("3) Exit");
            mainSelection = in.nextInt();

            switch (mainSelection) {
                case 1:
                    do {
                        System.out.println("1) View food");
                        System.out.println("2) Enter vending machine code");
                        System.out.println("3) Go back");
                        System.out.println("4) Exit");
                        subSelection = in.nextInt();

                        switch (subSelection) {
                            case 1:
                                showFood();
                                break;
                            case 2:
                                System.out.println("Enter vending machine code:");
                                String codeInput = in.next();
                                char code = codeInput.charAt(0);
                                int matchCount = 0;
                                Food selectedFood;
                                Iterator<Food> foodIterator = foodList.iterator();
                                while (foodIterator.hasNext()) {
                                    selectedFood = foodIterator.next();
                                    if (code == selectedFood.getFoodCode()) {
                                        matchCount++;
                                    }
                                }

                                if (matchCount != 0) {
                                    double price = selectFood(code);
                                    buyFood(price);
                                } else {
                                    System.out.println("Code not found, please try again.");
                                }
                                break;
                            case 3:
                                break;
                            case 4:
                                exit = true;
                                break;
                            default:
                                break;
                        }
                    } while (!exit);
                    break;

                case 2:
                    System.out.println("1) View drink");
                    System.out.println("2) Enter vending machine code");
                    System.out.println("3) Go back");
                    System.out.println("4) Exit");
                    subSelection = in.nextInt();

                    switch (subSelection) {
                        case 1:
                            showDrink();
                            break;
                        case 2:
                            System.out.println("Enter vending machine code:");
                            break;
                        case 3:
                            break;
                        case 4:
                            exit = true;
                            break;
                        default:
                            break;
                    }
                    break;

                case 3:
                    exit = true;
                    break;
                default:
                    break;
            }

        } while (!exit);
    }

    private static void addFood() {
        foodList.add(new Food("Tuna Wrap", 'K', 3.25));
        foodList.add(new Food("Veggie Burrito", 'L', 2.95));
        foodList.add(new Food("Chicken Nuggets", 'M', 4.10));
        foodList.add(new Food("Falafel Bowl", 'N', 3.85));
        foodList.add(new Food("BBQ Rib Sandwich", 'O', 5.40));
    }

    private static void addDrink() {
        drinkList.add(new Drink("Sparkling Lemonade", 'P', 1.25));
        drinkList.add(new Drink("Iced Tea", 'Q', 1.50));
        drinkList.add(new Drink("Mango Juice", 'R', 1.70));
        drinkList.add(new Drink("Hazelnut Coffee", 'S', 0.95));
        drinkList.add(new Drink("Vanilla Latte", 'T', 1.60));
    }

    private static void showFood() {
        for (Food food : foodList) {
            System.out.println(food.getFoodName() + " " + food.getFoodCode() + " " + food.getFoodPrice());
        }
    }

    private static void showDrink() {
        for (Drink drink : drinkList) {
            System.out.println(drink.getDrinkName() + " " + drink.getDrinkCode() + " " + drink.getDrinkPrice());
        }
    }

    private static double selectFood(char code) {
        for (Food food : foodList) {
            if (code == food.getFoodCode()) {
                System.out.println("You selected: " + food.getFoodName());
                System.out.println("Price: " + food.getFoodPrice());
                return food.getFoodPrice();
            }
        }
        return 0.0;
    }

    private static void buyFood(double price) {
        double amountDue = price;
        while (amountDue > 0) {
            System.out.println("Amount to pay: " + amountDue);
            double coin = in.nextDouble();
            if (coin == 2.00 || coin == 1.00 || coin == 0.50 || coin == 0.20 ||
                coin == 0.10 || coin == 0.05 || coin == 0.02 || coin == 0.01) {
                if (coin > amountDue) {
                    System.out.println("No change available, please insert the exact amount.");
                } else {
                    amountDue -= coin;
                }
            } else {
                System.out.println("Invalid coin.");
            }
        }
    }
}
