import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int daysPlunder = Integer.parseInt(scan.nextLine());
        int dailyPlunderIncome = Integer.parseInt(scan.nextLine());

        double expectedPlunderIncome = Double.parseDouble(scan.nextLine());
        double totalPlunder = 0;

        for (int i = 1; i <= daysPlunder; i++) {
            totalPlunder += dailyPlunderIncome;
            if (i % 3 == 0) {
                totalPlunder += dailyPlunderIncome * 0.5;
            }
            if (i % 5 == 0) {
                totalPlunder -= totalPlunder * 0.3;
            }
        }

        if (totalPlunder > expectedPlunderIncome) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double diff = totalPlunder * 100 / expectedPlunderIncome;
            System.out.printf("Collected only %.2f%% of the plunder.", diff);
        }
    }
}

