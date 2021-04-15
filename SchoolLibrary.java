import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> books = Arrays.stream(scan.nextLine()
                .split("&"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Done")) {
            String[] tokens = input.split(" \\| ");

            switch (tokens[0]) {
                case "Add Book":
                    String newBook = tokens[1];

                    if (books.contains(newBook)) {
                        break;
                    } else {
                        books.add(0, newBook);
                    }

                    break;
                case "Take Book":
                    String takeBook = tokens[1];
                    if (books.contains(takeBook)) {
                        books.remove(takeBook);
                    } else {
                        break;
                    }

                    break;
                case "Insert Book":
                    String newInsertBook = tokens[1];

                    books.add(books.size(), newInsertBook);

                    break;
                case "Check Book":
                    int checkBook = Integer.parseInt(tokens[1]);

                    if (checkBook > books.size()) {
                        break;
                    } else {
                        System.out.print(books.get(checkBook));
                        System.out.println();
                    }

                    break;
                case "Swap Books":
                    String bookOne = tokens[1];
                    String bookTwo = tokens[2];

                    if (books.contains(bookTwo) && books.contains(bookOne)) {
                        int newIndex = books.indexOf(bookOne);
                        int newIndex2 = books.indexOf(bookTwo);

                        String bookNew = books.get(newIndex);
                        String bookNew2 = books.get(newIndex2);

                        books.set(newIndex, bookNew2);
                        books.set(newIndex2, bookNew);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        for (int i = 0; i < books.size() - 1; i++) {
            System.out.print(books.get(i) + ", ");
        }
        System.out.println(books.get(books.size() - 1));
    }
}

