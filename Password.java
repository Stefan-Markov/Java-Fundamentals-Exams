import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String regex = ">(?<digits>[0-9]{3})\\|(?<lower>[a-z]{3})\\|(?<upper>[A-Z]{3})\\|(?<signs>[^<>]{3})<";

        Pattern pattern = Pattern.compile(regex);

        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String digits = matcher.group("digits");
                String lower = matcher.group("lower");
                String upper = matcher.group("upper");
                String signs = matcher.group("signs");

                StringBuilder sb = new StringBuilder();
                sb.append(digits).append(lower).append(upper).append(signs);
                System.out.printf("Password: %s%n", sb);

            } else {
                System.out.println("Try another password!");
            }
        }
    }
}

