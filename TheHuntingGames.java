import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int daysOfAdventure = Integer.parseInt(scan.nextLine());
        int countOfPlayers = Integer.parseInt(scan.nextLine());
        double groupEnergy = Double.parseDouble(scan.nextLine());


        double waterPerDayPerPerson = Double.parseDouble(scan.nextLine());
        double foodPerDayPerPerson = Double.parseDouble(scan.nextLine());

        double totalWater = daysOfAdventure * countOfPlayers * waterPerDayPerPerson;
        double totalFood = daysOfAdventure * countOfPlayers * foodPerDayPerPerson;


        for (int i = 1; i <= daysOfAdventure; i++) {
            double input = Double.parseDouble(scan.nextLine());

            if (groupEnergy <= 0) {
                break;
            }
            groupEnergy -= input;

            if (i % 2 == 0) {

                double boostEnergy = groupEnergy * 0.05;
                groupEnergy += boostEnergy;
                totalWater = totalWater - totalWater * 0.3;
            }
            if (i % 3 == 0) {
                double boostEnergy = groupEnergy * 0.1;
                groupEnergy += boostEnergy;
                totalFood = totalFood - (totalFood / 7);
            }

        }
        if (groupEnergy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",
                    totalFood, totalWater);
        }
    }
}
