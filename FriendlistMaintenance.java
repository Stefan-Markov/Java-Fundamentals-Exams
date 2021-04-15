import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendlistMaintenance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> contactNames = Arrays.stream(scan.nextLine().split(", "))
                .collect(Collectors.toList());

        String input = scan.nextLine();
        int blacklistNumberCount = 0;
        int lostNumberCount = 0;

        while (!input.equals("Report")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Blacklist":
                    String nameBlackList = tokens[1];

                    if (contactNames.contains(nameBlackList)) {

                        System.out.printf("%s was blacklisted.%n", nameBlackList);
                        int newIndexBlacklisted = contactNames.indexOf(nameBlackList);
                        String newNameBlacklisted = contactNames.set(newIndexBlacklisted, "Blacklisted");
                        blacklistNumberCount++;
                        break;
                    } else {
                        System.out.printf("%s was not found.", nameBlackList);
                    }

                    break;
                case "Error":
                    int errorIndex = Integer.parseInt(tokens[1]);
                    String checkname = contactNames.get(errorIndex);
                    if (checkname.equals("Blacklisted") || checkname.equals("Lost")) {
                        break;
                    } else {

                        String lostName = contactNames.get(errorIndex);
                        System.out.printf("%s was lost due to an error.%n", lostName);
                        String newLostName = contactNames.set(errorIndex, "Lost");
                        lostNumberCount++;
                    }

                    break;
                case "Change":
                    int indexChange = Integer.parseInt(tokens[1]);
                    String nameChange = tokens[2];

                    if (indexChange <= contactNames.size()) {
                        String changeOldName = contactNames.get(indexChange);


                        System.out.printf("%s changed his username to %s. %n", changeOldName, nameChange);
                        String newChangeName = contactNames.set(indexChange, nameChange);
                        break;
                    }
            }
            input = scan.nextLine();
        }

        System.out.printf("Blacklisted names: %d %n", blacklistNumberCount);
        System.out.printf("Lost names: %d %n", lostNumberCount);

        for (String element : contactNames) {
            System.out.print(element + " ");
        }
    }
}
