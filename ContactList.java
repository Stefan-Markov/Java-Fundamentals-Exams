import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> contacts = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Print")) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    String name = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < contacts.size()) {
                        if (contacts.contains(name)) {
                            contacts.add(index, name);
                        } else if (!contacts.contains(name)) {
                            contacts.add(contacts.size(), name);
                        }
                    }
                    break;
                case "Remove":
                    int removeIndex = Integer.parseInt(tokens[1]);
                    if (removeIndex >= 0 && removeIndex < contacts.size()) {
                        contacts.remove(removeIndex);
                        break;
                    }

                    break;
                case "Export":

                    int startIndex = Integer.parseInt(tokens[1]);
                    int countIndex = Integer.parseInt(tokens[2]);
                    int sumIndex = startIndex + countIndex;
                    if (sumIndex > contacts.size()) {
                        sumIndex = contacts.size();
                    }
                    for (int i = startIndex; i < sumIndex; i++) {
                        System.out.print(contacts.get(i) + " ");
                    }
                    System.out.println();
                    break;
                case "Print":
                    String command = tokens[1];
                    if (tokens[1].equals("Normal")) {
                        System.out.print("Contacts: ");
                        for (String element : contacts) {
                            System.out.print(element + " ");
                        }
                        return;
                    } else if (tokens[1].equals("Reversed")) {
                        Collections.reverse(contacts);
                        System.out.print("Contacts: ");
                        for (String element : contacts) {
                            System.out.print(element + " ");
                        }
                    }
                    return;
            }
            input = scan.nextLine();
        }
    }
}
