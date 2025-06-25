import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainCharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();

        TreeMap<String, Integer> characterMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            String character = String.valueOf(input.charAt(i));
            int count = 0;
            if (!characterMap.containsKey(character)) {
                count++;
                characterMap.put(character, count);
            } else {
                count = characterMap.get(character);
                count++;
                characterMap.replace(character, count);
            }
        }

        for (String key : characterMap.keySet()) {
            System.out.println("Character: " + key + ", Count: " + characterMap.get(key));
        }

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(characterMap.entrySet());
        Collections.sort(sortedEntries, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        sortedMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}
