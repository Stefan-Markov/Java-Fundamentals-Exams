import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Weapons {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> weapons = Arrays.stream(scan.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Move":
                    if (tokens[1].equals("Right")) {
                        int indexNow = Integer.parseInt(tokens[2]);

                        if (indexNow < weapons.size() - 1) {
                            String rightName = weapons.get(indexNow);
                            String namePlusOneRight = weapons.get(indexNow + 1);
                            int indexRightName = weapons.indexOf(rightName);
                            int indexPlusOneRight = weapons.indexOf(namePlusOneRight);

                            weapons.set(indexRightName, namePlusOneRight);
                            weapons.set(indexPlusOneRight, rightName);
                            break;
                        }

                    } else if (tokens[1].equals("Left")) {
                        int indexNow = Integer.parseInt(tokens[2]);

                        if (indexNow <= weapons.size() && indexNow != 0) {
                            String leftName = weapons.get(indexNow);

                            String namePlusOneRight = weapons.get(indexNow - 1);
                            int indexLeftName = weapons.indexOf(leftName);
                            int indexPlusOneLeft = weapons.indexOf(namePlusOneRight);

                            weapons.set(indexLeftName, namePlusOneRight);
                            weapons.set(indexPlusOneLeft, leftName);
                        }
                    }
                case "Check":
                    if (tokens[1].equals("Even")) {
                        for (int i = 0; i <= weapons.size() - 1; i++) {
                            if (i % 2 == 0) {
                                System.out.print(weapons.get(i) + " ");
                            }
                        }
                        System.out.println();

                        break;
                    } else if (tokens[1].equals("Odd")) {
                        for (int i = 0; i <= weapons.size() - 1; i++) {
                            if (i % 2 != 0) {
                                System.out.print(weapons.get(i) + " ");
                            }
                        }
                        System.out.println();
                        break;
                    }
            }
        }
    }
}