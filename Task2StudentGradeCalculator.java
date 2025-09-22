    import java.util.Scanner;

public class Task2StudentGradeCalculator {

    public static void main(String[] args) {
        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Get the number of subjects with validation
        int numSubjects = 0;
        while (true) {
            try {
                System.out.print("Enter the number of subjects: ");
                numSubjects = scanner.nextInt();
                if (numSubjects > 0) break;
                System.out.println("Please enter a positive number.");
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the buffer
            }
        }
        
        double totalMarks = 0;
        // Loop to get marks for each subject
        for (int i = 1; i <= numSubjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for subject " + i + " (out of 100): ");
                    double mark = scanner.nextDouble();
                    if (mark >= 0 && mark <= 100) {
                        totalMarks += mark;
                        break;
                    }
                    System.out.println("Invalid input. Marks must be between 0 and 100.");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear the buffer
                }
            }
        }

        // Calculate average percentage
        double averagePercentage = (numSubjects > 0) ? (totalMarks / numSubjects) : 0;

        // Assign grade based on percentage
        String grade;
        if (averagePercentage >= 90) grade = "A+";
        else if (averagePercentage >= 80) grade = "A";
        else if (averagePercentage >= 70) grade = "B";
        else if (averagePercentage >= 60) grade = "C";
        else if (averagePercentage >= 50) grade = "D";
        else grade = "F";

        // Display the results
        System.out.println("\n-------------------------------------");
        System.out.printf("Total Marks: %.2f\n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Final Grade: " + grade);
        System.out.println("-------------------------------------");

        // Close the scanner
        scanner.close();
    }
}
