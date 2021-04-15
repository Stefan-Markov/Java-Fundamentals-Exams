import java.util.Arrays;
import java.util.Scanner;

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] targets = Arrays.stream(scan.nextLine()
                .split("\\|"))
                .mapToInt(Integer::parseInt).toArray();

        int points = 0;

        String[] reversed = new String[targets.length];

        String input = scan.nextLine();

        while (!input.equals("Game over")) {

            String[] tokens = input.split("@");

            if (tokens[0].equals("Shoot Left")) {

                int startIndex = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);

                if (startIndex >= 0 && startIndex < targets.length) {

                    while (length != 0) {
                        if (startIndex > 0) {
                            startIndex--;
                            length--;
                        } else if (startIndex == 0) {
                            startIndex = targets.length - 1;
                            length--;
                        }
                    }
                    if (targets[startIndex] <= 5) {
                        points += targets[startIndex];
                        targets[startIndex] = 0;
                    } else {
                        points += 5;
                        targets[startIndex] -= 5;
                    }
                }

            } else if (tokens[0].equals("Shoot Right")) {
                int start = Integer.parseInt(tokens[1]);
                int length = Integer.parseInt(tokens[2]);

                if (start >= 0 && start < targets.length) {
                    while (length != 0) {
                        if (start < targets.length - 1) {
                            start++;
                            length--;
                        } else if (start == targets.length - 1) {
                            start = 0;
                            length--;
                        }
                    }
                    if (targets[start] <= 5) {
                        points += targets[start];
                        targets[start] = 0;
                    } else {
                        points += 5;
                        targets[start] -= 5;
                    }
                }
                //Обръщане на реда на последователност
            } else if (tokens[0].equals("Reverse")) {
                for (int i = targets.length - 1; i >= 0; i--) {
                    reversed[reversed.length - 1 - i] = "" + targets[i];
                }
            }
            input = scan.nextLine();
        }

        System.out.print(String.join(" - ", reversed));
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!", points);
    }
}

