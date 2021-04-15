import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, List<String>> race = new TreeMap<>();
        String input = scan.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("->");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String road = tokens[1];
                    String racer = tokens[2];

                    if (!race.containsKey(road)) {
                        race.put(road, new ArrayList<>());
                        race.get(road).add(racer);
                    } else {
                        race.get(road).add(racer);
                    }
                    break;
                case "Move":

                    String currentRoad = tokens[1];
                    String racerMove = tokens[2];
                    String newRoad = tokens[3];

                    if (race.get(currentRoad).contains(racerMove)) {

                        race.get(currentRoad).remove(racerMove);
                        race.get(newRoad).add(racerMove);
                    }
                    break;
                case "Close":

                    String roadClosed = tokens[1];
                    race.remove(roadClosed);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
