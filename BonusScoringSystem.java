import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double countOfStudents = Integer.parseInt(scan.nextLine());
        double lessonsNumber = Integer.parseInt(scan.nextLine());
        double additionalBonus = Integer.parseInt(scan.nextLine());

        int checklection = 0;
        double bonusMax = 0;

        for (int i = 0; i < countOfStudents; i++) {

            int studentAttendance = Integer.parseInt(scan.nextLine());

            if (studentAttendance > checklection) {
                checklection = studentAttendance;
            }

            double totalBonus = (studentAttendance / lessonsNumber) * (5 + additionalBonus);

            if (totalBonus > bonusMax) {
                bonusMax = (totalBonus);
            }
        }

        double finalResult = Math.round(bonusMax);
        System.out.printf("Max Bonus: %.0f.%n", finalResult);
        System.out.printf("The student has attended %d lectures.", checklection);
    }
}
