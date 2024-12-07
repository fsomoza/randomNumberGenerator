package org.kiko.dev;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Create a Scanner object for taking input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for input
        System.out.println("Enter a number, it will be a range between 0 and the number you entered:");
        int number = scanner.nextInt(); // Take integer input

        System.out.println("Enter the amount of seconds you want to run the program:");
        int seconds = scanner.nextInt(); // Take integer input

        System.out.println("Now just wait " + seconds + " seconds");

        Map<Integer, Integer> map = new HashMap<>();

        // Initialize map with keys from 0 to (number - 1)
        for (int i = 0; i < number; i++) {
            map.put(i, 0);
        }

        Random random = new Random();
        long startTime = System.currentTimeMillis(); // Record the start time
        long duration = seconds * 1000L; // Convert seconds to milliseconds

        while (System.currentTimeMillis() - startTime < duration) {
            int randomIntBounded = random.nextInt(number); // Generate a number between 0 (inclusive) and number (exclusive)
            int counter = map.get(randomIntBounded);
            map.put(randomIntBounded, counter + 1);
        }

        // Sort the map entries by value in descending order
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Print the sorted list
        System.out.println("Number\t\tCount");
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }

        // Generate CSV file with the results using semicolon as delimiter
        String csvFile = "results.csv";
        try (FileWriter writer = new FileWriter(csvFile)) {
            // Write the header
            writer.append("Number;Count\n");

            // Write the data
            for (Map.Entry<Integer, Integer> entry : sortedList) {
                writer.append(entry.getKey().toString())
                        .append(';')
                        .append(entry.getValue().toString())
                        .append('\n');
            }

            System.out.println("Results have been written to " + csvFile);
        } catch (IOException e) {
            System.err.println("An error occurred while writing the CSV file:");
            e.printStackTrace();
        }

        // Close the scanner
        scanner.close();
    }
}
