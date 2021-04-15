import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String regex = "\\|(?<nameBoss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i <n ; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){

                String nameBoss = matcher.group("nameBoss");
                String title = matcher.group("title");

                System.out.printf("%s, The %s%n",nameBoss,title);
                int bossNameLength= 0;

                for (int j = 0; j <nameBoss.length() ; j++) {
                    bossNameLength++;
                }
                System.out.printf(">> Strength: %d%n",bossNameLength);

                int titleLength = 0;
                for (int j = 0; j <title.length() ; j++) {
                    titleLength++;
                }
                System.out.printf(">> Armour: %d%n",titleLength);
            }else{
                System.out.println("Access denied!");
            }
        }
    }
}

