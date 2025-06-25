package CompanySalaries;

import java.util.Scanner;

public class MainCompany {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Juan's job category:");
        String category = scanner.nextLine();

        System.out.println("Enter Juan's years of experience:");
        int yearsOfExperience = scanner.nextInt();

        SalaryCalculator salaryPedro = new SalaryCalculator();
        salaryPedro.calculateSalary(category, yearsOfExperience);

        System.out.println(salaryPedro.toString());
    }
}
