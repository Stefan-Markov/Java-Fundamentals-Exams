import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        TreeMap<String, List<String>> inbox = new TreeMap<>();
        int userCount = 0;

        while (!input.equals("Statistics")) {
            String[] tokens = input.split("->");

            String command = tokens[0];

            switch (command) {
                case "Add":
                    String username = tokens[1];
                    if (!inbox.containsKey(username)) {
                        inbox.putIfAbsent(username, new ArrayList<>());
                        userCount++;
                    } else {
                        System.out.printf("%s is already registered%n", username);
                    }
                    break;
                case "Send":
                    String name = tokens[1];
                    String mail = tokens[2];

                    if (inbox.containsKey(name) && !inbox.get(name).contains(mail)) {

                        inbox.get(name).add(mail);
                    }
                    break;
                case "Delete":

                    String user = tokens[1];
                    if (!inbox.containsKey(user)) {
                        System.out.printf("%s not found!%n", user);
                    } else {
                        inbox.remove(user);
                        userCount--;
                    }
                    break;
            }
            input = scan.nextLine();
        }

        System.out.printf("Users count: %d%n", userCount);

        if (userCount <= 0) {
            return;
        } else {
            for (Map.Entry<String, List<String>> entry : inbox.entrySet()) {
                System.out.printf("%s%n", entry.getKey());

                for (String s : entry.getValue()) {
                    System.out.printf(" - %s%n", s);
                }
            }
        }
    }
}
