import java.util.Scanner;

public class Username {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        StringBuilder recall = new StringBuilder(input);

        String command = scan.nextLine();
        while (!command.equals("Sign up")) {

            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Case":
                    String signal = tokens[1];
                    if (signal.equals("lower")) {

                        String lower = recall.toString().toLowerCase();
                        recall.setLength(0);
                        System.out.println(lower);
                        recall.append(lower);
                        break;
                    } else {
                        String upper = recall.toString().toUpperCase();
                        recall.setLength(0);
                        System.out.println(upper);
                        recall.append(upper);
                        break;
                    }

                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + 1;
                    StringBuilder sb = new StringBuilder();

                    String reverse = recall.substring(startIndex, endIndex);
                    if (startIndex > 0 && endIndex < recall.length()) {
                        for (int i = reverse.length() - 1; i >= 0; i--) {
                            char symbol = reverse.charAt(i);
                            sb.append(symbol);

                        }
                    }
                    System.out.println(sb);

                    break;
                case "Cut":
                    String cuttingMachine = tokens[1];
                    if (recall.toString().contains(cuttingMachine)) {
                        String cuttingResult = recall.toString().replace(cuttingMachine, "");
                        System.out.println(cuttingResult);
                        break;
                    } else {

                        System.out.printf("The word %s doesn't contain %s.%n", recall, cuttingMachine);
                    }

                    break;
                case "Replace":
                    String sign = tokens[1];
                    if (recall.toString().contains(sign)) {
                        String replace = recall.toString().replace(sign, "*");
                        System.out.println(replace);
                        recall.setLength(0);
                        recall.append(replace);
                        break;
                    }

                    break;
                case "Check":
                    String check = tokens[1];
                    if (recall.toString().contains(check)) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.%n", check);
                    }
                    break;
            }
            command = scan.nextLine();
        }
    }
}
