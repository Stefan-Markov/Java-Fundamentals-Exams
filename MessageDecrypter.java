import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "^(?<signal>[%|$])(?<action>[A-Z][a-z]{2,})\\1: \\[(?<group1>[0-9]+)\\]\\|\\[(?<group2>[0-9]+)\\]\\|\\[(?<group3>[0-9]+)\\]\\|$";

        Pattern pattern = Pattern.compile(regex);
        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String action = matcher.group("action");
                int group1 = Integer.parseInt(matcher.group("group1"));
                int group2 = Integer.parseInt(matcher.group("group2"));
                int group3 = Integer.parseInt(matcher.group("group3"));

                char symbol1 = ((char) group1);
                char symbol2 = ((char) group2);
                char symbol3 = ((char) group3);

                System.out.printf("%s: %s%s%s%n", action, symbol1, symbol2, symbol3);

            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
