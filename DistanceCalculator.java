import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int steps = Integer.parseInt(scan.nextLine());
        double smSteps = Double.parseDouble(scan.nextLine());

        int target = Integer.parseInt(scan.nextLine());
        int countSteps5 = 0;
        for (int i = 1; i <= steps; i++) {
            if (i % 5 == 0) {
                countSteps5++;
            }
        }
        int stepsNormal = steps - countSteps5;

        double distanceNormalSteps = stepsNormal * smSteps;
        double distanceSmallSteps = countSteps5 * (smSteps * 0.7);

        double fullDistance = distanceNormalSteps + distanceSmallSteps;

        double finalResult = fullDistance / target;

        System.out.printf("You travelled %.2f%% of the distance!", finalResult);
    }
}
