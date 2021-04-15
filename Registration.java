import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String reg = "U\\$(?<name>[A-Z]{1}[a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}[ \\d]{1,})P@\\$";

        Pattern pattern = Pattern.compile(reg);
        int number = Integer.parseInt(scan.nextLine());
        int count = 0;

        for (int i = 0; i < number; i++) {
            String input = scan.nextLine();

            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("Registration was successful");
                count++;

                String name = matcher.group("name");
                String password = matcher.group("password");

                System.out.printf("Username: %s, Password: %s%n", name, password);
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", count);
    }
}
