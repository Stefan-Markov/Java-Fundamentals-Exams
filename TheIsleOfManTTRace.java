import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTTRace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "([#$%*&])(?<name>[A-z]+)(\\1)=(?<lenght>\\d+)!!(?<code>.+)";

        Pattern pattern = Pattern.compile(regex);

        String input = scan.nextLine();
        boolean isFound = false;

        while (!isFound) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("lenght"));
                String code = matcher.group("code");

                if (length == code.length()) {
                    StringBuilder codee = new StringBuilder();
                    for (int i = 0; i < code.length(); i++) {
                        char symbol = (char) (code.charAt(i) + length);
                        codee.append(symbol);
                        isFound = true;
                    }
                    System.out.printf("Coordinates found! %s -> %s", name, codee);
                    if (isFound) {
                        break;
                    }
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
            input = scan.nextLine();
        }
    }
}
