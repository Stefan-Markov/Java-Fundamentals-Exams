import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class NikuldensMeals {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = 0;

        TreeMap<String, List<String>> information = new TreeMap<>();

        while (!input.equals("Stop")) {
            String[] tokens = input.split("-");

            switch (tokens[0]) {
                case "Like":
                    String guest = tokens[1];
                    String meals = tokens[2];

                    information.putIfAbsent(guest, new ArrayList<>());
                    if (information.get(guest).contains(meals)) {
                        break;
                    } else {
                        information.get(guest).add(meals);
                    }

                    break;
                case "Unlike":
                    String name = tokens[1];
                    String dinner = tokens[2];
                    if (!information.containsKey(name)) {
                        System.out.printf("%s is not at the party.\n", name);
                        break;

                    }
                    if (information.get(name).contains(dinner)) {

                        information.get(name).remove(dinner);
                        count++;
                        System.out.printf("%s doesn't like the %s.\n", name, dinner);
                    } else {
                        System.out.printf("%s doesn't have the %s in his/her collection.\n", name, dinner);
                    }

            }
            input = scan.nextLine();
        }

        information.entrySet().stream().sorted((s1, s2) -> {
            if (s2.getValue().size() - s1.getValue().size() == 0) {

                return s1.getKey().compareTo(s2.getKey());
            } else {
                return s2.getValue().size() - s1.getValue().size();
            }
        }).forEach(s -> {
            System.out.printf("%s: ", s.getKey());
            System.out.println(String.join(", ", s.getValue()));
        });

        System.out.printf("Unliked meals: %d", count);
    }
}
