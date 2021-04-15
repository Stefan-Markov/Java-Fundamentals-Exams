import java.util.Scanner;

public class NikuldensCharity {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        String input = scan.nextLine();

        while (!input.equals("Finish")) {
            String[] tokens = input.split(" ");
            switch (tokens[0]) {

                case "Replace":
                    String currentChar = tokens[1];
                    String newChar = tokens[2];

                    message = message.replace(currentChar, newChar);
                    System.out.println(message);
                    break;

                case "Make":

                    String change = tokens[1];
                    if (change.equals("Upper")) {
                        message = message.toUpperCase();
                        System.out.println(message);
                    } else {
                        message = message.toLowerCase();
                        System.out.println(message);
                    }

                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + 1;
                    String removeString = "";
                    if (startIndex > 0 && message.length() > endIndex) {

                        removeString = message.substring(startIndex, endIndex);

                    } else {

                        System.out.println("Invalid indexes!");
                        break;
                    }

                    if (message.contains(removeString)) {
                        message = message.replace(removeString, "");
                        System.out.println(message);
                    }

                    break;
                case "Check":
                    String checkString = tokens[1];
                    if (message.contains(checkString)) {
                        System.out.printf("Message contains %s%n", checkString);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", checkString);
                    }

                    break;
                case "Sum":
                    int sumStart = Integer.parseInt(tokens[1]);
                    int sumEND = Integer.parseInt(tokens[2]) + 1;
                    if (sumStart > 0 && message.length() > sumEND) {
                        int sum = 0;

                        String checking = message.substring(sumStart, sumEND);
                        for (int i = 0; i < checking.length(); i++) {
                            char symbol = checking.charAt(i);
                            sum += symbol;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
            }
            input = scan.nextLine();
        }
    }
}
