import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainWriter {
    public static void main(String[] args) {
        String filePath = "./java-exercises/SavedFile.txt";
        System.out.println("Type anything you want, it will all be saved in a log:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.append(input);
            writer.newLine();
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Now let's read what you wrote in the log:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
