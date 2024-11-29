package com.example.Task4;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

    public class Task4 {
        public static void main(String[] args) {
            try {
                Scanner scanner = new Scanner(System.in);


                System.out.print("Enter the base currency (for example USD): ");
                String baseCurrency = scanner.nextLine().toUpperCase();

                System.out.print("Enter the target currency (for example EUR): ");
                String targetCurrency = scanner.nextLine().toUpperCase();


                String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
                HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode != 200) {
                    System.out.println("Failed to fetch exchange rates. Please check the base currency and try again.");
                    return;
                }

                StringBuilder response = new StringBuilder();
                Scanner apiScanner = new Scanner(connection.getInputStream());
                while (apiScanner.hasNext()) {
                    response.append(apiScanner.nextLine());
                }
                apiScanner.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                if (!jsonResponse.getJSONObject("rates").has(targetCurrency)) {
                    System.out.println("Target currency not supported.");
                    return;
                }

                double exchangeRate = jsonResponse.getJSONObject("rates").getDouble(targetCurrency);


                System.out.print("Enter the amount to convert: ");
                double amount = scanner.nextDouble();


                double convertedAmount = amount * exchangeRate;

                System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }











