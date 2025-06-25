
package CompanySalaries;

public class SalaryCalculator {
    private static final int BASE_SALARY = 1040;
    
    private static final int EMPLOYEE_BONUS = 10;
    private static final int MANAGER_BONUS = 30;
    private static final int EXECUTIVE_BONUS = 50;

    private static final int AMATEUR_EXPERIENCE_BONUS = 100;
    private static final int JUNIOR_EXPERIENCE_BONUS = 300;
    private static final int EXPERT_EXPERIENCE_BONUS = 500;

    private int finalSalary = 0;

    public int calculateSalary(String employeeCategory, int yearsOfExperience) {
        int totalSalary = BASE_SALARY;

        switch (employeeCategory) {
            case "Employee":
                totalSalary += BASE_SALARY % EMPLOYEE_BONUS;
                break;
            case "Manager":
                totalSalary += BASE_SALARY % MANAGER_BONUS;
                break;
            case "Executive":
                totalSalary += BASE_SALARY % EXECUTIVE_BONUS;
                break;
            default:
                System.out.println("Unknown category. Base salary applied without bonus.");
        }

        if (yearsOfExperience > 0 && yearsOfExperience < 3) {
            totalSalary += AMATEUR_EXPERIENCE_BONUS;
        } else if (yearsOfExperience >= 3 && yearsOfExperience <= 5) {
            totalSalary += JUNIOR_EXPERIENCE_BONUS;
        } else if (yearsOfExperience > 5) {
            totalSalary += EXPERT_EXPERIENCE_BONUS;
        }

        finalSalary = totalSalary;
        return finalSalary;
    }

    @Override
    public String toString() {
        return "The employee's total salary is €" + finalSalary;
    }
}
