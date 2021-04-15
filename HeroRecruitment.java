import java.util.*;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, List<String>> info = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            String command = tokens[0];
            switch (command) {

                case "Enroll":
                    String name = tokens[1];

                    if (info.containsKey(name)) {
                        System.out.printf("%s is already enrolled.%n", name);
                        break;
                    } else {
                        info.putIfAbsent(name, new ArrayList<>());
                    }

                    break;
                case "Learn":
                    String heroName = tokens[1];
                    String spell = tokens[2];

                    if (!info.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);

                    } else if (info.containsKey(heroName) && !info.get(heroName).contains(spell)) {
                        info.get(heroName).add(spell);

                    } else if (info.containsKey(heroName) && info.get(heroName).contains(spell)) {
                        System.out.printf("%s has already learnt %s.%n", heroName, spell);

                    }

                    break;
                case "Unlearn":
                    String nameHero = tokens[1];
                    String unlearnSpell = tokens[2];

                    if (info.containsKey(nameHero) && info.get(nameHero).contains(unlearnSpell)) {

                        info.get(nameHero).remove(unlearnSpell);
                    } else if (!info.containsKey(nameHero)) {
                        System.out.printf("%s doesn't exist.%n", nameHero);
                    } else if (info.containsKey(nameHero) && !info.get(nameHero).contains(unlearnSpell)) {

                        System.out.printf("%s doesn't know %s.%n", nameHero, unlearnSpell);
                    }
            }
            input = scan.nextLine();

        }

        System.out.println("Heroes:");
        for (Map.Entry<String, List<String>> value : info.entrySet()) {
            System.out.printf("== %s: %s%n", value.getKey(), value.getValue()
                    .toString().replaceAll("[\\[\\]]", ""));
        }
    }
}

