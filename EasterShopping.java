import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shopsToVisit = Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());

        int number = Integer.parseInt(scan.nextLine());

        int i = 0;
        for (i = 0; i < number; i++) {

            String[] tokens = scan.nextLine().split(" ");

            switch (tokens[0]) {
                case "Include":
                    String nameShopAdd = tokens[1];
                    shopsToVisit.add(shopsToVisit.size(), nameShopAdd);

                    break;
                case "Visit":
                    if (tokens[1].equals("first")) {
                        int visitNumber = Integer.parseInt(tokens[2]);
                        if (visitNumber > shopsToVisit.size()) {

                            break;
                        } else {
                            for (int j = 0; j < visitNumber; j++) {

                                shopsToVisit.set(j, "Remove");
                            }
                        }
                        while (shopsToVisit.contains("Remove")) {
                            shopsToVisit.remove("Remove");
                        }

                        break;
                    } else if (tokens[1].equals("last")) {
                        int visitLastShopsNumber = Integer.parseInt(tokens[2]);
                        if (visitLastShopsNumber > shopsToVisit.size()) {
                            break;
                        } else {
                            int index = shopsToVisit.size() - visitLastShopsNumber;
                            for (int j = index; j < shopsToVisit.size(); j++) {
                                shopsToVisit.set(j, "Remove");
                            }
                            while (shopsToVisit.contains("Remove")) {
                                shopsToVisit.remove("Remove");
                            }
                        }
                    }

                    break;
                case "Prefer":
                    int indexOne = Integer.parseInt(tokens[1]);
                    int indexTwo = Integer.parseInt(tokens[2]);
                    if (indexOne >= 0 && indexOne <= shopsToVisit.size()) {
                        if (indexTwo >= 0 && indexTwo <= shopsToVisit.size()) {

                            String nameOneShop = shopsToVisit.get(indexOne);
                            String nameTwoShop = shopsToVisit.get(indexTwo);

                            shopsToVisit.set(indexOne, nameTwoShop);
                            shopsToVisit.set(indexTwo, nameOneShop);
                            break;
                        }
                    }

                    break;
                case "Place":
                    String placeShopName = tokens[1];
                    int indexPlacesShopName = Integer.parseInt(tokens[2]);
                    if (indexPlacesShopName >= 0 && indexPlacesShopName <= shopsToVisit.size()) {
                        shopsToVisit.add(indexPlacesShopName + 1, placeShopName);
                        break;
                    }
                    break;
            }
        }
        System.out.println("Shops left:");
        for (String element : shopsToVisit) {
            System.out.print(element + " ");
        }
    }
}
