import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int healt = 100;
        int bitcoins = 0;

        int counter = 0;
        String[] input = scan.nextLine().split("\\|");
        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split(" ");
            if (tokens[0].equals("potion")) {
                int addHealth = Integer.parseInt(tokens[1]);

                if (healt + addHealth > 100) {
                    int diff = 100 - healt;
                    healt += diff;
                    System.out.printf("You healed for %d hp.%n", diff);
                    System.out.printf("Current health: %d hp.%n", healt);
                    counter++;

                } else {
                    healt += addHealth;
                    System.out.printf("You healed for %d hp.%n", addHealth);
                    System.out.printf("Current health: %d hp.%n", healt);
                    counter++;
                }
            } else if (tokens[0].equals("chest")) {

                int addBitcoin = Integer.parseInt(tokens[1]);
                bitcoins += addBitcoin;
                System.out.printf("You found %d bitcoins.%n", addBitcoin);
                counter++;
            } else {
                String monster = tokens[0];
                int attack = Integer.parseInt(tokens[1]);

                healt -= attack;

                if (healt <= 0) {
                    System.out.printf("You died! Killed by %s.%n", monster);
                    counter++;
                    System.out.printf("Best room: %d", counter);
                    break;
                } else {
                    System.out.printf("You slayed %s.%n", monster);
                    counter++;
                }
            }
        }
        if (healt > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d", healt);
        }
    }
}

