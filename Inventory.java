import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> itemsList = Arrays.stream(scan.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Collect":
                    String newItem = tokens[2];
                    if (itemsList.contains(newItem)) {
                        break;
                    } else {
                        itemsList.add(itemsList.size(), newItem);
                    }

                    break;
                case "Drop":
                    String dropItem = tokens[2];
                    if (itemsList.contains(tokens[2])) {
                        itemsList.remove(dropItem);
                        break;
                    }

                    break;
                case "Combine":

                    String combinedItems = tokens[3];
                    String[] twoItems = combinedItems.split(":");
                    String getNewItem = twoItems[0];
                    String getOldItem = twoItems[1];
                    if (itemsList.contains(getNewItem)) {

                        int indexForNewItem = itemsList.indexOf(getNewItem);
                        itemsList.add(indexForNewItem + 1, getOldItem);
                    }

                    break;
                case "Renew":
                    String renewItem = tokens[2];
                    if (itemsList.contains(renewItem)) {
                        itemsList.remove(renewItem);
                        itemsList.add(itemsList.size(), renewItem);
                        break;

                    }
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println(String.join(", ", itemsList));
    }
}

