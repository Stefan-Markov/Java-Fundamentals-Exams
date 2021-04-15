import java.util.*;
import java.util.stream.Collectors;

public class FroggySquad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> frogs = new ArrayList<>();

        String[] frogsArr = scan.nextLine().split("\\s+");
        frogs.addAll(Arrays.asList(frogsArr));
        String input = scan.nextLine();
        while (true) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Join":
                    String name = tokens[1];
                    int counter = 0;
                    for (int i = 0; i < frogs.size(); i++) {
                        counter++;
                    }
                    frogs.add(counter, name);
                    break;

                case "Jump":
                    int put = Integer.parseInt(tokens[2]);
                    String nameJump = tokens[1];
                    frogs.add(put, nameJump);
                    break;
                case "Dive":
                    int indexDive = Integer.parseInt(tokens[1]);
                    if (indexDive < frogs.size()) {
                        frogs.remove(indexDive);
                    }
                    break;
                case "First":

                    int indexFor = Integer.parseInt(tokens[1]);
                    int sum = 0;

                    if (indexFor > frogs.size()) {
                        for (String element : frogs) {
                            System.out.print(element + " ");
                        }
                        System.out.println();
                    }
                    break;
                case "Last":
                    int indexLast = Integer.parseInt(tokens[1]);

                    System.out.println(frogs.stream().skip(Math.max(frogs.size() - indexLast, 0)).
                            collect(Collectors.joining(" ")));
                    break;
                case "Print":
                    if (tokens[1].equals("Reversed")) {
                        Collections.reverse(frogs);
                        System.out.print("Frogs: ");
                        for (String element : frogs) {

                            System.out.print(element + " ");
                        }
                        return;
                    } else if (tokens[1].equals("Normal")) {
                        System.out.print("Frogs: ");
                        for (String element : frogs) {
                            System.out.print(element + " ");
                        }
                    }
                    return;
            }
            input = scan.nextLine();
        }
    }
}

