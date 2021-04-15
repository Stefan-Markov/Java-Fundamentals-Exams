import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        String input = scan.nextLine();

        StringBuilder recall = new StringBuilder(message);

        while (!input.equals("Complete")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {

                case "Make":
                    String switcher = tokens[1];

                    if (switcher.equals("Upper")) {
                        String upper = recall.toString().toUpperCase();
                        recall.setLength(0);
                        System.out.println(upper);
                        recall.append(upper);
                        break;
                    } else {
                        String lower = recall.toString().toLowerCase();
                        recall.setLength(0);
                        System.out.println(lower);
                        recall.append(lower);
                    }

                    break;
                case "GetDomain":

                    int index = Integer.parseInt(tokens[1]);

                    if (index > 0 && index < recall.length()) {
                        int count = 0;
                        for (int i = 0; i < recall.length(); i++) {
                            count++;
                        }
                        int start = count - index;

                        String cut = (String) recall.subSequence(start, count);
                        System.out.println(cut);
                    }

                    break;
                case "GetUsername":

                    if (recall.toString().contains("@")) {
                        int cutIndex = recall.indexOf("@");
                        String getUser = recall.substring(0, cutIndex);
                        System.out.println(getUser);
                    } else {

                        System.out.printf("The email %s doesn't contain the @ symbol.%n", recall);
                    }
                    break;

                case "Replace":
                    char symbol = tokens[1].charAt(0);

                    String replace = recall.toString().replace(symbol, '-');
                    System.out.println(replace);
                    break;
                case "Encrypt":
                    StringBuilder ascii = new StringBuilder();

                    for (int i = 0; i < recall.length(); i++) {
                        char signal = recall.charAt(i);
                        int intChar = signal;
                        ascii.append(intChar);
                        ascii.append(" ");
                    }
                    System.out.println(ascii);
            }
            input = scan.nextLine();
        }
    }
}
