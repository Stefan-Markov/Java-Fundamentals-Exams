import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> items = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("No Money")) {

            String[] tokens = input.split(" ");
            switch (tokens[0]) {

                case "OutOfStock":
                    String outOfStock = tokens[1];
                    while (items.contains(outOfStock)) {
                        int indexChange = items.indexOf(outOfStock);
                        items.set(indexChange, "None");
                    }

                    break;
                case "Required":
                    String giftName = tokens[1];
                    int indexName = Integer.parseInt(tokens[2]);

                    if (indexName >= 0 && indexName < items.size() - 1) {

                        items.set(indexName, giftName);
                        break;
                    }

                    break;
                case "JustInCase":
                    String justInCaseGift = tokens[1];
                    items.remove(items.size() - 1);
                    items.add(items.size(), justInCaseGift);
                    break;
            }
            input = scan.nextLine();
        }

        while (items.contains("None")) {
            items.remove("None");
        }
        for (String element : items) {

            System.out.print((element + " "));
        }
    }
}
