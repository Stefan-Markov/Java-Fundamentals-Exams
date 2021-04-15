import java.util.Scanner;

public class BiscuitsFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int biscuitPerWorked = Integer.parseInt(scan.nextLine());
        int numbersOfWorkers = Integer.parseInt(scan.nextLine());

        int otherFactoryBiscuits = Integer.parseInt(scan.nextLine());
        int days = 30;

        double totalProduction = 0;
        double normalProduction = biscuitPerWorked;

        double lessProduction = (biscuitPerWorked * 0.75);
        ;
        for (int i = 1; i <= days; i++) {
            if (i % 3 == 0) {
                totalProduction += Math.ceil(lessProduction * numbersOfWorkers);
            } else {
                totalProduction += Math.ceil(normalProduction * numbersOfWorkers);
            }
        }

        System.out.printf("You have produced %.0f biscuits for the past month.%n", totalProduction);
        if (totalProduction > otherFactoryBiscuits) {
            double diff = totalProduction - otherFactoryBiscuits;
            double finalDiff = (diff / otherFactoryBiscuits) * 100;
            System.out.printf("You produce %.2f percent more biscuits.", finalDiff);
        } else {
            double diff = totalProduction / otherFactoryBiscuits;

            double finalDiff = Math.abs((diff * 100) - 100);
            System.out.printf("You produce %.2f percent less biscuits.", finalDiff);
        }
    }
}

