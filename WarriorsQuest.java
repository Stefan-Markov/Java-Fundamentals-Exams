import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String skill = scan.nextLine();
        String input = scan.nextLine();

        StringBuilder output = new StringBuilder(skill);

        while (!input.equals("For Azeroth")) {

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "GladiatorStance":
                    String strUpper = output.toString().toUpperCase();
                    output.setLength(0);
                    output.append(strUpper);
                    System.out.println(output);

                    break;
                case "DefensiveStance":
                    String strLower = output.toString().toLowerCase();
                    output.setLength(0);
                    output.append(strLower);
                    System.out.println(output);

                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < output.length()) {
                        char letter = tokens[2].charAt(0);
                        output.setCharAt(index, letter);
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }

                    break;
                case "Target":
                    String action = tokens[1];
                    String substring = tokens[2];
                    int firstIndex = output.indexOf(substring);
                    while (firstIndex != -1) {
                        switch (action) {
                            case "Change":
                                String strongSubstring = tokens[3];
                                output.replace(firstIndex, firstIndex + substring.length(), strongSubstring);
                                break;
                            case "Remove":
                                output.delete(firstIndex, firstIndex + substring.length());
                                break;
                        }
                        firstIndex = output.indexOf(substring);
                    }
                    System.out.println(output);
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }
            input = scan.nextLine();
        }
    }
}
