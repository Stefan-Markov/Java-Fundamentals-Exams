import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] decode = scan.nextLine().split(" ");

        StringBuilder result = new StringBuilder();

        String regex = "[d-z#|{}]+";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String match = matcher.group();
            if (input.length() != match.length()) {
                System.out.println("This is not the book you are looking for.");

            } else {
                for (int i = 0; i < match.length(); i++) {
                    result.append((char) (input.charAt(i) - 3));
                }
                while (result.toString().contains(decode[0])) {
                    result = new StringBuilder(result.toString().replace(decode[0], decode[1]));
                }
                System.out.println(result);
            }
        }
    }
}
