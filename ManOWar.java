import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scan.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int health = Integer.parseInt(scan.nextLine());
        double min = health * 0.2;

        String input = scan.nextLine();

        while (!input.equals("Retire")) {

            String[] tokens = input.split(" ");
            switch (tokens[0]) {

                case "Fire":
                    int indexFire = Integer.parseInt(tokens[1]);
                    int damageFire = Integer.parseInt(tokens[2]);

                    if (indexFire >= 0 && indexFire < warShip.size() - 1) {
                        int getPoints = warShip.get(indexFire);
                        int indexPoints = warShip.indexOf(getPoints);
                        warShip.set(indexPoints, getPoints - damageFire);

                        int afterShootPoints = warShip.get(indexPoints);

                        if (afterShootPoints < 0) {
                            System.out.print("You won! The enemy ship has sunken.");
                            warShip.remove(indexPoints);
                            return;
                        }
                    }

                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damage = Integer.parseInt(tokens[3]);

                    if (startIndex >= 0 && endIndex <= pirateShip.size()) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int damageShip = pirateShip.get(i);
                            int resultAfterShop = pirateShip.indexOf(damageShip);

                            pirateShip.set(resultAfterShop, damageShip - damage);
                        }

                        for (int i = startIndex; i <= endIndex; i++) {
                            int damageShip = pirateShip.get(i);
                            if (damageShip < 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                int indexOfSinkShip = pirateShip.indexOf(damageShip);
                                warShip.remove(indexOfSinkShip);
                                return;
                            }
                        }
                    }

                    break;
                case "Repair":
                    int indexRepair = Integer.parseInt(tokens[1]);
                    int healthRepair = Integer.parseInt(tokens[2]);

                    if (indexRepair >= 0 && indexRepair <= pirateShip.size()) {
                        int pointOfRepairIndex = pirateShip.get(indexRepair);
                        pirateShip.set(indexRepair, pointOfRepairIndex + healthRepair);

                        int afterRepairPoints = pirateShip.get(indexRepair);
                        if (afterRepairPoints > health) {
                            afterRepairPoints = health;
                        }
                    }

                    break;
                case "Status":
                    int counter = 0;

                    for (int i = 0; i < pirateShip.size(); i++) {
                        int needRepairShip = pirateShip.get(i);

                        if (needRepairShip < min) {
                            counter++;
                        }
                    }
                    if (counter > 0) {
                        System.out.printf("%d sections need repair.%n", counter);
                    }
            }
            input = scan.nextLine();
        }
        int totalPointsPirateShip = 0;
        for (int i = 0; i < pirateShip.size(); i++) {
            int getPoints = pirateShip.get(i);
            totalPointsPirateShip += getPoints;

        }
        int totalPointsWarShip = 0;
        for (int i = 0; i < warShip.size(); i++) {
            int getPoints = warShip.get(i);
            totalPointsWarShip += getPoints;
        }

        System.out.printf("Pirate ship status: %d%n", totalPointsPirateShip);
        System.out.printf("Warship status: %d", totalPointsWarShip);
    }
}
