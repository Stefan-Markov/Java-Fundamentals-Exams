import java.util.Scanner;

public class StringManipulatorGroup1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        String input = scan.nextLine();
        StringBuilder star = new StringBuilder(message);

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            String command = tokens[0];

            switch ((command)) {
                case "Translate":

                    String symbol1 = tokens[1];
                    String symbol2 = tokens[2];

                    String translate = star.toString().replace(symbol1, symbol2);

                    star.setLength(0);
                    star.append(translate);
                    System.out.println(translate);

                    break;
                case "Includes":
                    String include = tokens[1];

                    if (star.toString().contains(include)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }

                    break;
                case "Start":
                    String startString = tokens[1];

                    if (star.toString().startsWith(startString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }

                    break;
                case "Lowercase":

                    String lower = star.toString().toLowerCase();
                    System.out.println(lower);
                    star.setLength(0);
                    star.append(lower);

                    break;
                case "FindIndex":
                    String char1 = tokens[1];

                    if (star.toString().contains(char1)) {
                        int index = star.toString().lastIndexOf(char1);
                        System.out.println(index);
                    }

                    break;
                case "Remove":

                    int startIndex = Integer.parseInt(tokens[1]);
                    int lengthIndex = Integer.parseInt(tokens[2]) + startIndex;
                    StringBuilder remove = new StringBuilder();

                    for (int i = startIndex; i <= lengthIndex - 1; i++) {
                        char symbol = star.charAt(i);
                        remove.append(symbol);

                    }
                    String forNow = remove.toString();
                    String printRemove = star.toString();
                    printRemove = printRemove.replace(forNow, "");
                    System.out.println(printRemove);
                    star.setLength(0);
                    star.append(printRemove);
            }
            input = scan.nextLine();
        }
    }
}
