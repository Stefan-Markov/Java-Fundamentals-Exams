import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> items = Arrays.stream(scan.nextLine()
                .split("\\|"))
                .collect(Collectors.toList());

        List<String> lookItems = new ArrayList<>();
        String input = scan.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i <= tokens.length - 1; i++) {
                        if (!items.contains(tokens[i])) {
                            items.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":

                    int dropIndex = Integer.parseInt(tokens[1]);
                    if (dropIndex >= 0 && dropIndex <= items.size()) {
                        String dropName = items.get(dropIndex);

                        items.remove(dropIndex);
                        items.add(items.size(), dropName);
                    }

                    break;
                case "Steal":
                    int stealNumber = Integer.parseInt(tokens[1]);
                    int stealIndex = items.size() - stealNumber;

                    for (int i = stealIndex; i <= items.size() - 1; i++) {
                        String newList = items.get(i);
                        lookItems.add(newList);
                    }
                    for (int i = 0; i < lookItems.size() - 1; i++) {
                        System.out.print(lookItems.get(i) + ", ");
                    }
                    System.out.print(lookItems.get(lookItems.size() - 1));
                    for (int i = items.size() - 1; i >= stealIndex; i--) {
                        items.remove(i);
                    }
                    break;
            }
            input = scan.nextLine();
        }

        double count = 0;
        double countWords = 0;
        for (int i = 0; i < items.size(); i++) {
            countWords++;
            String index = items.get(i);

            for (int j = 0; j < index.length(); j++) {
                count++;
            }
        }
        double diff = count / countWords;

        if (countWords == 0) {
            System.out.println();
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.println();
            System.out.printf("Average treasure gain: %.2f pirate credits.", diff);

        }
    }
}
