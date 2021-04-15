import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TanksCollector {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> tankList = Arrays.stream(scan.nextLine()
                .split(", "))
                .collect(Collectors.toList());

        int numbersOfCommand = Integer.parseInt(scan.nextLine());
        int i = 0;

        String input = scan.nextLine();

        if (numbersOfCommand > i) {
            while (true) {
                String[] tokens = input.split(", ");

                switch (tokens[0]) {
                    case "Add":
                        String nameAdd = tokens[1];
                        if (tankList.contains(nameAdd)) {
                            System.out.println("Tank is already bought");
                            i++;
                            break;
                        } else {

                            System.out.println("Tank successfully bought");
                            tankList.add(nameAdd);
                            i++;
                            break;
                        }
                    case "Remove":
                        String removeTank = tokens[1];
                        if (tankList.contains(removeTank)) {
                            tankList.remove(removeTank);
                            System.out.println("Tank successfully sold");
                            i++;
                            break;
                        } else {
                            System.out.println("Tank not found");
                            i++;
                            break;
                        }

                    case "Remove At":
                        int removeAtIndex = Integer.parseInt(tokens[1]);
                        if (removeAtIndex <= tankList.size()) {
                            tankList.remove(removeAtIndex);
                            System.out.println("Tank successfully sold");
                            i++;
                            break;
                        } else {
                            System.out.println("Index out of range");
                            i++;
                            break;
                        }
                    case "Insert":
                        int insertIndexTank = Integer.parseInt(tokens[1]);
                        String insertTankNmae = tokens[2];
                        if (insertIndexTank <= tankList.size()) {

                            if (tankList.contains(insertTankNmae)) {
                                System.out.println("Tank is already bought");
                                i++;
                                break;
                            } else {
                                tankList.add(insertIndexTank, insertTankNmae);
                                System.out.println("Tank successfully bought");
                                i++;
                                break;
                            }
                        } else {
                            System.out.println("Index out of range");
                            i++;
                            break;
                        }
                }
                if (i >= numbersOfCommand) {
                    break;
                }
                input = scan.nextLine();
            }
        }
        for (int j = 0; j < tankList.size() - 1; j++) {
            System.out.print(tankList.get(j) + ", ");
        }
        System.out.println(tankList.get(tankList.size() - 1));
    }
}
