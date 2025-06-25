import java.io.*;
import java.util.*;
import java.util.regex.*;

public class MainAgroFoodCompany {
    private static ArrayList<FreshProduct> freshProducts = new ArrayList<>();
    private static ArrayList<RefrigeratedProduct> refrigeratedProducts = new ArrayList<>();
    private static ArrayList<FrozenWaterProduct> frozenByWaterProducts = new ArrayList<>();
    private static ArrayList<FrozenNitrogenProduct> frozenByNitrogenProducts = new ArrayList<>();
    private static ArrayList<FrozenAirProduct> frozenByAirProducts = new ArrayList<>();

    private static String expirationDate;
    private static int batchNumber;
    private static String packagingDate;
    private static String countryOfOrigin;
    private static int temperature;
    private static final String FILE_PATH = "./java-exercises/AgroFoodCompany/savedProducts.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean showMenu = true;

        while (showMenu) {
            showMenu = menu();
        }

        System.out.println("Do you want to save the products you've entered? (yes/no)");
        scanner.nextLine();
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                writer.write("Fresh Products:\n");
                for (FreshProduct p : freshProducts) {
                    writer.write(p + "\n");
                }
                writer.write("Refrigerated Products:\n");
                for (RefrigeratedProduct p : refrigeratedProducts) {
                    writer.write(p + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean menu() {
        System.out.println("Choose an option:");
        System.out.println("1) Add Fresh Product");
        System.out.println("2) Add Refrigerated Product");
        System.out.println("3) Add Frozen Product");
        System.out.println("4) Exit");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                addFreshProduct();
                break;
            case 2:
                addRefrigeratedProduct();
                break;
            case 3:
                addFrozenProduct();
                break;
            case 4:
                return false;
            default:
                System.out.println("Invalid option");
        }
        return true;
    }

    private static void addFreshProduct() {
        System.out.println("Enter expiration date:");
        expirationDate = scanner.nextLine();

        System.out.println("Enter batch number:");
        batchNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter packaging date:");
        packagingDate = scanner.nextLine();
        while (!isValidDate(packagingDate)) {
            System.out.println("Invalid date format. Please re-enter:");
            packagingDate = scanner.nextLine();
        }

        System.out.println("Enter country of origin:");
        countryOfOrigin = scanner.nextLine();

        FreshProduct product = new FreshProduct(expirationDate, batchNumber, packagingDate, countryOfOrigin);
        freshProducts.add(product);

        System.out.println("Do you want to view all fresh products?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        if (scanner.nextInt() == 1) {
            printFreshProducts();
        }
    }

    private static void addRefrigeratedProduct() {
        System.out.println("Enter expiration date:");
        expirationDate = scanner.nextLine();

        System.out.println("Enter batch number:");
        batchNumber = scanner.nextInt();

        System.out.println("Enter food authority code:");
        int authorityCode = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter packaging date:");
        packagingDate = scanner.nextLine();
        while (!isValidDate(packagingDate)) {
            System.out.println("Invalid date format. Please re-enter:");
            packagingDate = scanner.nextLine();
        }

        System.out.println("Enter recommended storage temperature:");
        temperature = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter country of origin:");
        countryOfOrigin = scanner.nextLine();

        RefrigeratedProduct product = new RefrigeratedProduct(expirationDate, batchNumber, authorityCode, packagingDate, temperature, countryOfOrigin);
        refrigeratedProducts.add(product);

        System.out.println("Do you want to view all refrigerated products?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        if (scanner.nextInt() == 1) {
            printRefrigeratedProducts();
        }
    }

    private static void addFrozenProduct() {
        System.out.println("Choose type of frozen product:");
        System.out.println("1) Frozen by Air");
        System.out.println("2) Frozen by Water");
        System.out.println("3) Frozen by Nitrogen");
        System.out.println("4) Go Back");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> addFrozenByAir();
            case 2 -> addFrozenByWater();
            case 3 -> addFrozenByNitrogen();
            case 4 -> {
                return;
            }
            default -> System.out.println("Invalid option");
        }
    }

    private static void addFrozenByAir() {
        collectCommonFrozenData();

        System.out.println("Enter nitrogen percentage:");
        int nitrogen = scanner.nextInt();
        System.out.println("Enter oxygen percentage:");
        int oxygen = scanner.nextInt();
        System.out.println("Enter carbon dioxide percentage:");
        int carbon = scanner.nextInt();
        System.out.println("Enter water vapor percentage:");
        int vapor = scanner.nextInt();

        FrozenAirProduct product = new FrozenAirProduct(expirationDate, batchNumber, packagingDate, countryOfOrigin,
                temperature, nitrogen, oxygen, carbon, vapor);
        frozenByAirProducts.add(product);

        System.out.println("View all frozen-by-air products?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        if (scanner.nextInt() == 1) {
            printFrozenByAirProducts();
        }
    }

    private static void addFrozenByWater() {
        collectCommonFrozenData();

        System.out.println("Enter grams of salt:");
        int saltGrams = scanner.nextInt();
        System.out.println("Enter liters of water:");
        int liters = scanner.nextInt();

        FrozenWaterProduct product = new FrozenWaterProduct(expirationDate, batchNumber, packagingDate, countryOfOrigin,
                temperature, saltGrams, liters);
        frozenByWaterProducts.add(product);

        System.out.println("View all frozen-by-water products?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        if (scanner.nextInt() == 1) {
            printFrozenByWaterProducts();
        }
    }

    private static void addFrozenByNitrogen() {
        collectCommonFrozenData();

        scanner.nextLine(); // consume buffer
        System.out.println("Enter exposure time:");
        String exposureTime = scanner.nextLine();

        FrozenNitrogenProduct product = new FrozenNitrogenProduct(expirationDate, batchNumber, packagingDate, countryOfOrigin,
                temperature, exposureTime);
        frozenByNitrogenProducts.add(product);

        System.out.println("View all frozen-by-nitrogen products?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        if (scanner.nextInt() == 1) {
            printFrozenByNitrogenProducts();
        }
    }

    private static void collectCommonFrozenData() {
        System.out.println("Enter expiration date:");
        expirationDate = scanner.nextLine();

        System.out.println("Enter batch number:");
        batchNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter packaging date:");
        packagingDate = scanner.nextLine();

        System.out.println("Enter country of origin:");
        countryOfOrigin = scanner.nextLine();

        System.out.println("Enter recommended storage temperature:");
        temperature = scanner.nextInt();
    }

    private static boolean isValidDate(String date) {
        String regex = "([0-3][0-9]/[0-1][0-9]/[0-9]{4})";
        return Pattern.compile(regex).matcher(date).matches();
    }

    private static void printFreshProducts() {
        for (FreshProduct p : freshProducts) {
            System.out.println(p);
        }
    }

    private static void printRefrigeratedProducts() {
        for (RefrigeratedProduct p : refrigeratedProducts) {
            System.out.println(p);
        }
    }

    private static void printFrozenByAirProducts() {
        for (FrozenAirProduct p : frozenByAirProducts) {
            System.out.println(p);
        }
    }

    private static void printFrozenByWaterProducts() {
        for (FrozenWaterProduct p : frozenByWaterProducts) {
            System.out.println(p);
        }
    }

    private static void printFrozenByNitrogenProducts() {
        for (FrozenNitrogenProduct p : frozenByNitrogenProducts) {
            System.out.println(p);
        }
    }
}
