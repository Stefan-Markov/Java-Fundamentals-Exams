import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = Integer.parseInt(scan.nextLine());

        String input = scan.nextLine();

        int countUsers = 0;

        TreeMap<String, List<Integer>> account = new TreeMap<>();

        while (!input.equals("Statistics")) {
            String[] tokens = input.split("=");

            String command = tokens[0];
            switch (command) {
                case "Add":
                    String name = tokens[1];
                    int send = Integer.parseInt(tokens[2]);
                    int receive = Integer.parseInt(tokens[3]);

                    account.putIfAbsent(name, new ArrayList<>());
                    countUsers++;


                    // индекс 0 за S E N D
                    account.get(name).add(0, send);

                    // индекс 1 за R E C E I V E
                    account.get(name).add(1, receive);


                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];

                    if (account.containsKey(sender) && account.containsKey(receiver)) {
                        int sendMessage = account.get(sender).get(0);
                        account.get(sender).set(0, sendMessage + 1);

                        int receiveMessage = account.get(receiver).get(1);
                        account.get(receiver).set(1, receiveMessage + 1);
                    }

                    if (account.get(sender).get(0) + account.get(sender).get(1) >= capacity) {
                        System.out.printf("%s reached the capacity!%n", sender);
                        account.remove(sender);
                        countUsers--;
                    }

                    if (account.get(receiver).get(1) + account.get(receiver).get(0) >= capacity) {
                        System.out.printf("%s reached the capacity!%n", receiver);
                        account.remove(receiver);
                        countUsers--;
                    }

                    break;
                case "Empty":
                    String emptyUser = tokens[1];
                    if (account.containsKey(emptyUser)) {
                        account.remove(emptyUser);
                        countUsers--;
                    } else if (emptyUser.equals("All")) {
                        account.clear();
                        countUsers = 0;
                    }
            }
            input = scan.nextLine();
        }

        System.out.printf("Users count: %d%n", countUsers);

        account.entrySet().stream()
                .sorted((s2, s1) -> s1.getValue().get(1).compareTo(s2.getValue().get(1)))
                .forEach(s -> System.out.printf("%s - %d%n", s.getKey(), s.getValue().get(0) + s.getValue().get(1)));
    }
}
