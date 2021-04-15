import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TasksPlanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("Complete")) {
                int task = Integer.parseInt(tokens[1]);

                numbers.set(task, 0);

            } else if (tokens[0].equals("Change")) {
                int index = Integer.parseInt(tokens[1]);
                int time = Integer.parseInt(tokens[2]);
                numbers.set(index, time);
            } else if (tokens[0].equals("Drop")) {
                int drop = Integer.parseInt(tokens[1]);
                numbers.set(drop, -1);
            }
            if (tokens[0].equals("Count")) {
                int counter = 0;

                switch (tokens[1]) {
                    case "Completed": {

                        for (Integer number : numbers) {
                            if (number == 0) {
                                counter++;
                            }
                        }
                        System.out.println(counter);
                        break;
                    }
                    case "Incomplete": {

                        for (Integer number : numbers) {
                            if (number > 0) {
                                counter++;
                            }
                        }
                        System.out.println(counter);
                        break;
                    }

                    case "Dropped":
                        for (int i = 0; i < numbers.size(); i++) {
                            for (int number : numbers) {
                                if (number < 0) {
                                    counter++;
                                }
                            }
                            System.out.println(counter);
                            break;
                        }
                }
            }
            input = scan.nextLine();
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 0) {
                if (i < numbers.size() - 1) {
                    System.out.print(numbers.get(i) + " ");
                } else {
                    System.out.print(numbers.get(i));
                }
            }
        }
    }
}

