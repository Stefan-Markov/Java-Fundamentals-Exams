import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());

        String regex = "!(?<name>[A-Z][a-z]{3,})!:\\[(?<action>[A-za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);

        StringBuilder sumChars = new StringBuilder();

        for (int i = 0; i < number; i++) {

            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String name = matcher.group("name");
                String action = matcher.group("action");

                for (int j = 0; j < action.length(); j++) {
                    char symbol = action.charAt(j);
                    int intChar = symbol;
                    sumChars.append(intChar);
                    sumChars.append(" ");

                }
                System.out.printf("%s: ", name);
                System.out.println(sumChars);
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
