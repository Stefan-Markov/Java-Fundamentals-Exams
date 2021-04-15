import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> items = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Stop")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Delete":
                    int deleteIndex = Integer.parseInt(tokens[1]);

                    if (deleteIndex < 0 || deleteIndex > items.size()) {
                        break;

                    }
                    items.remove(deleteIndex + 1);
                    break;
                case "Swap":
                    String swapNameOne = tokens[1];
                    String swapNameTwo = tokens[2];

                    if (items.contains(swapNameTwo) && items.contains(swapNameOne)) {
                        int swapIndexOne = items.indexOf(swapNameOne);
                        int swapIndexTwo = items.indexOf(swapNameTwo);

                        items.set(swapIndexOne, swapNameTwo);
                        items.set(swapIndexTwo, swapNameOne);
                    }
                    break;
                case "Put":
                    String putName = tokens[1];
                    int putIndex = Integer.parseInt(tokens[2]);

                    if (putIndex == items.size()) {
                        items.add(putIndex, putName);
                        break;
                    } else if (putIndex < items.size()) {
                        items.add(putIndex - 1, putName);
                        break;
                    }
                    break;
                case "Sort":
                    Collections.sort(items);
                    break;
                case "Replace":

                    String OldWord = tokens[1];
                    String newWord = tokens[2];
                    if (items.contains(newWord)) {
                        int newWordIndex = items.indexOf(newWord);
                        items.set(newWordIndex, OldWord);
                        break;

                    }
                    break;
            }
            input = scan.nextLine();
        }

        for (String element : items) {
            System.out.print(element + " ");
        }
    }
}
