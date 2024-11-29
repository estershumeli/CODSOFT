package com.example.Task2;
import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine();

        double totalMarks = 0;

        System.out.print("Enter marks obtained in all subjects separatedd by one single space ");
        String input = scanner.nextLine();
        String[] marksArray = input.split(" ");

        if (marksArray.length != numSubjects) {
            System.out.println("Error, the number of marks entered does not match the number of subjects.");
            return;
        }

        for (String mark : marksArray) {
            try {
                double marks = Double.parseDouble(mark);
                if (marks < 0 || marks > 100) {
                    System.out.println("Error: Marks must be between 0 and 100.");
                    return;
                }
                totalMarks += marks;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number entered. Please enter valid value for marks.");
                return;
            }
        }

        double averagePercentage = totalMarks / numSubjects;
        char grade = calculateGrade(averagePercentage);

        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks + "/" + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }


}
