import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, List<String>> info = new LinkedHashMap<>();
        String input = scan.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split("->");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String store = tokens[1];
                    String item = tokens[2];

                    String[] allItems = item.split(",");

                    if (!info.containsKey(store)) {

                        info.put(store, new ArrayList<>());
                        for (String s : allItems) {
                            info.get(store).add(s);
                        }

                    } else if (info.containsKey(store)) {
                        for (String s : allItems) {
                            info.get(store).add(s);
                        }
                    }
                    break;
                case "Remove":
                    String remove = tokens[1];
                    info.remove(remove);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Stores list:");
        info.entrySet().stream()
                .sorted((f, s) -> {
                    int diff = s.getValue().size() - f.getValue().size();
                    if (diff == 0) {
                        return s.getKey().compareTo(f.getKey());
                    } else {
                        return s.getValue().size() - f.getValue().size();
                    }
                }).forEach(entry -> {
            System.out.println(entry.getKey());

            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("<<%s>>%n", entry.getValue().get(i));
            }
        });
    }
}
