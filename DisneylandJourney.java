import java.util.Scanner;

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double cost = Double.parseDouble(scan.nextLine());
        int months = Integer.parseInt(scan.nextLine());

        double moneyToSave = 0;

        double moneyAdd = 250;
        for (int i = 1; i <= months; i++) {

            if (i % 2 == 0 && i % 4 != 0) {
                moneyAdd = cost * 0.25;
                moneyToSave = moneyToSave + moneyAdd;
            }
            if (i % 2 != 0) {
                moneyToSave -= (moneyToSave * 0.16);
                moneyToSave += +cost * 0.25;
            }
            if (i % 4 == 0) {
                moneyToSave += moneyToSave * 0.25;
                moneyToSave += cost * 0.25;
            }
        }
        if (moneyToSave > cost) {
            double result = moneyToSave - cost;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", result);
        } else {
            double result = cost - moneyToSave;
            System.out.printf("Sorry. You need %.2flv. more.", result);
        }
    }
}
