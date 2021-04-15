import java.util.Arrays;
import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Switch":
                    int indexNew = Integer.parseInt(tokens[1]);
                    if (indexNew >= 0 && indexNew < numbers.length) {
                        numbers[indexNew] = numbers[indexNew] * -1;

                        break;
                    }
                    break;
                case "Change":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.length) {
                        numbers[index] = Integer.parseInt(tokens[2]);
                        break;
                    }

                    break;
                case "Sum":
                    if (tokens[1].equals("Negative")) {
//                        System.out.println(Arrays.stream(numbers).filter(value -> value < 0).sum());
                        int sum = 0;
                        for (int element : numbers) {
                            if (element < 0) {
                                sum = element + sum;
                            }
                        }
                        System.out.println(sum);
                        break;
                    } else if (tokens[1].equals("Positive")) {
//                        System.out.println(Arrays.stream(numbers).filter(value -> value >= 0).sum());
                        int sum = 0;
                        for (int element : numbers
                        ) {
                            if (element > 0) {
                                sum = sum + element;
                            }
                        }
                        System.out.println(sum);
                        break;
                    } else if (tokens[1].equals("All")) {
//                        System.out.println(Arrays.stream(numbers).sum());
                        int sum = 0;
                        for (int element : numbers) {
                            sum = sum + element;
                        }
                        System.out.println(sum);
                    }
            }
            input = scan.nextLine();
        }
//        Arrays.stream(numbers).filter(value -> value >= 0).forEach(e -> System.out.printf("%d ", e));

        for (int element : numbers) {
            if (element > 0) {
                System.out.print(element + " ");
            }
        }
    }
}