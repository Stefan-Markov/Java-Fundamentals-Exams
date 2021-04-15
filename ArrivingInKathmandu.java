import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKathmandu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = "^(?<name>[A-Za-z0-1!@#$?]+)=(?<digit>\\d+)<<(?<code>.+)$";

        Pattern pattern = Pattern.compile(regex);

        StringBuilder sb = new StringBuilder();
        String input = scan.nextLine();

        while (!input.equals("Last note")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String name = matcher.group("name");
                int digit = Integer.parseInt(matcher.group("digit"));
                String code = matcher.group("code");
                if (digit == code.length()) {

                    for (int i = 0; i < name.length(); i++) {
                        char symbol = name.charAt(i);
                        if (symbol == '!' || symbol == '@' || symbol == '$' || symbol == '?' || symbol == '#') {
                            continue;
                        } else {
                            sb.append(symbol);
                        }
                    }
                    System.out.printf("Coordinates found! %s -> %s%n", sb.toString(), code);
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
