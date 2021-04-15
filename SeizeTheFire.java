import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeizeTheFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> items = Arrays.stream(scan.nextLine().split("#")).collect(Collectors.toList());
        List<Integer> newList = new ArrayList<>();

        int water = Integer.parseInt(scan.nextLine());

        double totalFire = 0;
        double effort = 0;
        for (int i = 0; i < items.size(); i++) {
            String[] input = items.get(i).split(" = ");

            switch (input[0]) {
                case "High":
                    int cell = Integer.parseInt(input[1]);

                    if (cell < 81 || cell > 125) {
                        break;
                    } else {
                        water -= cell;
                        if (water < 0) {
                            break;
                        }
                        effort = effort + cell * 0.25;
                        totalFire = totalFire + cell;
                    }
                    newList.add(cell);
                    break;
                case "Low":
                    int cellLow = Integer.parseInt(input[1]);

                    if (cellLow < 1 || cellLow > 50) {
                        break;
                    } else {

                        water -= cellLow;
                        if (water < 0) {
                            break;
                        }
                        effort = effort + cellLow * 0.25;
                        totalFire = totalFire + cellLow;
                    }
                    newList.add(cellLow);
                    break;
                case "Medium":
                    int cellMedium = Integer.parseInt(input[1]);

                    if (cellMedium < 51 || cellMedium > 80) {
                        break;

                    } else {
                        water -= cellMedium;
                        if (water < 0) {
                            break;
                        }

                        effort = effort + cellMedium * 0.25;
                        totalFire = totalFire + cellMedium;

                    }
                    newList.add(cellMedium);
                    break;
            }
        }

        System.out.println("Cells:");

        for (int element : newList) {

            System.out.println(" - " + element);

        }
        System.out.printf("Effort: %.2f", effort);
        System.out.println();
        System.out.printf("Total Fire: %.0f", totalFire);
    }
}
