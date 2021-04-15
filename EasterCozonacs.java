import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        double priceFloorKg = Double.parseDouble(scan.nextLine());

        double priceForEags = priceFloorKg * 0.75;
        double priceForMilk = priceFloorKg * 1.25;

        double milk250mlPrice = priceForMilk / 4;

        double totalPriceforCozunak = milk250mlPrice + priceForEags + priceFloorKg;

        double countMadeCozunaks = 0;
        double coloredEggs = 0;

        while (budget > totalPriceforCozunak) {

            budget -= totalPriceforCozunak;
            countMadeCozunaks++;
            coloredEggs += 3;

            if (countMadeCozunaks % 3 == 0) {
                coloredEggs = coloredEggs - (countMadeCozunaks - 2);
            }
        }
        System.out.printf("You made %.0f cozonacs! Now you have %.0f eggs and %.2fBGN left.",
                countMadeCozunaks, coloredEggs, budget);
    }
}
