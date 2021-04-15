import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, List<Integer>> ship = new TreeMap<>();

        String input = scan.nextLine();

        while (!input.equals("Sail")) {
            String[] tokens = input.trim().split("\\|\\|");

            String name = tokens[0];
            int people = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!ship.containsKey(name)) {
                ship.put(name, new ArrayList<>());
//               индекс 0 за People
                ship.get(name).add(0, people);

                ship.get(name).add(1, gold);
            } else if (ship.containsKey(name)) {
                int peopleSum = ship.get(name).get(0);
                int goldSum = ship.get(name).get(1);

                ship.get(name).set(0, people + peopleSum);
                ship.get(name).set(1, gold + goldSum);
            }
            input = scan.nextLine();
        }
        String command = scan.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.trim().split("=>");

            String sign = tokens[0];

            if (sign.equals("Plunder")) {

                String town = tokens[1];
                int killedpPeople = Integer.parseInt(tokens[2]);
                int stoledGold = Integer.parseInt(tokens[3]);

                int indexPeople = ship.get(town).get(0);
                int indexGold = ship.get(town).get(1);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, stoledGold, killedpPeople);
                int diffKilledPeople = indexPeople - killedpPeople;
                int diffStolenGold = indexGold - stoledGold;
                //               индекс 0 за People

                ship.get(town).set(0, diffKilledPeople);
                ship.get(town).set(1, diffStolenGold);


                if (diffKilledPeople <= 0) {
                    System.out.printf("%s has been wiped off the map!%n", town);
                    ship.remove(town);
                }
                if (diffStolenGold <= 0) {
                    System.out.printf("%s has been wiped off the map!%n", town);
                    ship.remove(town);
                }

            } else if (sign.equals("Prosper")) {

                String town = tokens[1];

                int goldProsper = Integer.parseInt(tokens[2]);

                if (goldProsper <= 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {

                    int goldSum = ship.get(town).get(1);
                    int sum = goldSum + goldProsper;
                    ship.get(town).set(1, sum);

                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldProsper, town, sum);
                }
            }
            command = scan.nextLine();
        }

        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", ship.values().size());
        ship.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().get(1).compareTo(s1.getValue().get(1)))
                .forEach(s -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", s.getKey(),
                        s.getValue().get(0), s.getValue().get(1)));
    }
}