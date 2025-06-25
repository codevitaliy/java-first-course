
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MainRandomNumberArray {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the size of the array:");
        int arraySize = scanner.nextInt();

        System.out.println("Enter the maximum value for random numbers:");
        int maxRandom = scanner.nextInt();

        System.out.println("Enter the minimum value for random numbers:");
        int minRandom = scanner.nextInt();

        while (maxRandom < minRandom) {
            System.out.println("Maximum value must be greater than minimum. Enter again:");
            System.out.println("Enter the maximum value for random numbers:");
            maxRandom = scanner.nextInt();
            System.out.println("Enter the minimum value for random numbers:");
            minRandom = scanner.nextInt();
        }

        Integer[] randomNumbersArray = new Integer[arraySize];
        for (int i = 0; i < arraySize; i++) {
            randomNumbersArray[i] = (int) (Math.random() * (maxRandom - minRandom + 1)) + minRandom;
            System.out.println("Generated random number: " + randomNumbersArray[i]);
        }

        MainRandomNumberArray.menu(randomNumbersArray);
    }

    public static void menu(Integer[] randomNumbersArray) {
        String response = "";

        do {
            System.out.println("Choose an option:");
            System.out.println("1) Sort the array");
            System.out.println("2) Search for a value");
            System.out.println("3) Show odd numbers in the array");
            System.out.println("4) Show the highest number in the array");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    Arrays.sort(randomNumbersArray);
                    System.out.println("The array has been sorted in ascending order:");
                    for (int num : randomNumbersArray) {
                        System.out.println(num);
                    }
                    break;

                case 2:
                    System.out.println("Which value do you want to search for?");
                    int valueToSearch = scanner.nextInt();
                    int count = 0;
                    for (int num : randomNumbersArray) {
                        if (valueToSearch == num) {
                            count++;
                        }
                    }
                    if (count > 0) {
                        System.out.println("The value appears " + count + " times in the array.");
                    } else {
                        System.out.println("The value is not present in the array.");
                    }
                    break;

                case 3:
                    ArrayList<Integer> oddNumbers = new ArrayList<>();
                    for (int num : randomNumbersArray) {
                        if (num % 2 == 1) {
                            oddNumbers.add(num);
                        }
                    }
                    System.out.println("Odd numbers in the array: " + oddNumbers);
                    break;

                case 4:
                    Arrays.sort(randomNumbersArray, Collections.reverseOrder());
                    System.out.println("The highest number in the array is: " + randomNumbersArray[0]);
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

            System.out.println("Do you want to continue? (yes/no)");
            scanner.nextLine(); // Clear buffer
            response = scanner.nextLine();

        } while (response.equalsIgnoreCase("yes"));
    }
}
