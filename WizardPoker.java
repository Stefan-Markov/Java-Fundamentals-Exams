import java.util.*;
import java.util.stream.Collectors;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> items = Arrays.stream(scan.nextLine().split(":")).collect(Collectors.toList());
        List<String> newCardDesk = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("Ready")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Add":
                    String nameCard = tokens[1];
                    if (items.contains(nameCard)) {
                        items.remove(nameCard);
                        newCardDesk.add(nameCard);
                        break;
                    } else {
                        System.out.println("Card not found.");
                        break;
                    }

                case "Insert":
                    String newCardName = tokens[1];
                    int newCardNameIndex = Integer.parseInt(tokens[2]);

                    if (items.contains(newCardName)) {
                        newCardDesk.add(newCardNameIndex, newCardName);
                        break;
                    } else {
                        System.out.println("Error!");
                        break;
                    }
                case "Remove":
                    String removeCardName = tokens[1];
                    if (newCardDesk.contains(removeCardName)) {
                        newCardDesk.remove(removeCardName);
                        break;
                    } else {
                        System.out.println("Card not found.");
                        break;
                    }
                case "Swap":
                    String firstCardName = tokens[1];
                    String secondCardName = tokens[2];

                    int firstCardNameIndex = newCardDesk.indexOf(firstCardName);
                    int secondCardNameIndex = newCardDesk.indexOf(secondCardName);

                    newCardDesk.set(firstCardNameIndex, secondCardName);
                    newCardDesk.set(secondCardNameIndex, firstCardName);
                    break;
                case "Shuffle":

                    Collections.reverse(newCardDesk);
                    break;
            }
            input = scan.nextLine();
        }

        for (String element : newCardDesk) {
            System.out.print(element + " ");
        }
    }
}
