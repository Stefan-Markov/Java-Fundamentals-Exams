import java.util.Scanner;

public class ActivationKeys {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();
        StringBuilder upper = new StringBuilder(message);

        String input = scan.nextLine();

        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];
            switch (command) {
                case "Contains":
                    String contains = upper.toString();
                    String check = tokens[1];
                    if (contains.contains(check)) {

                        System.out.printf("%s contains %s%n", message, check);
                    } else {
                        System.out.println("Substring not found!");
                    }

                    break;
                case "Flip":
                    String secondCommand = tokens[1];

                    if (secondCommand.equals("Upper")) {
                        int startIndex = Integer.parseInt(tokens[2]);
                        int endIndex = Integer.parseInt(tokens[3]);
                        String message1 = upper.toString();
                        String keys = message1.substring(startIndex, endIndex);
                        keys = keys.toUpperCase();

                        upper.replace(startIndex, endIndex, keys);
                        System.out.println(upper.toString());


                    } else if (secondCommand.equals("Lower")) {
                        int startIndex = Integer.parseInt(tokens[2]);
                        int endIndex = Integer.parseInt(tokens[3]);
                        String message1 = upper.toString();

                        String keys = message1.substring(startIndex, endIndex);
                        keys = keys.toLowerCase();

                        upper.replace(startIndex, endIndex, keys);
                        System.out.println(upper);
                    }

                    break;
                case "Slice":
                    int indexStart = Integer.parseInt(tokens[1]);
                    int endStart = Integer.parseInt(tokens[2]);

                    String cuttingString1 = upper.toString();
                    String cuttingString2 = upper.toString();

                    cuttingString1 = cuttingString1.substring(0, indexStart);
                    cuttingString2 = cuttingString2.substring(endStart);

                    upper.setLength(0);
                    upper.append(cuttingString1).append(cuttingString2);
                    System.out.println(upper);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.printf("Your activation key is: %s", upper);
    }
}
