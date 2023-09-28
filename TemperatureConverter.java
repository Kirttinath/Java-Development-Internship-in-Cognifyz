import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.print("Enter a temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);

        double convertedTemperature;

        if (unit == 'C' || unit == 'c') {
            // Convert from Celsius to Fahrenheit
            convertedTemperature = celsiusToFahrenheit(temperature);
            System.out.println("Converted temperature in Fahrenheit: " + convertedTemperature + " °F");
        } else if (unit == 'F' || unit == 'f') {
            // Convert from Fahrenheit to Celsius
            convertedTemperature = fahrenheitToCelsius(temperature);
            System.out.println("Converted temperature in Celsius: " + convertedTemperature + " °C");
        } else {
            System.out.println("Invalid unit of measurement. Please enter 'C' or 'F'.");
        }

        scanner.close();
    }

    // Method to convert Celsius to Fahrenheit
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
