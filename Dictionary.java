import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+\\|\\s+");
        Map<String, List<String>> words = new TreeMap<>();

        for (String s : input) {
            String[] tokens = s.split(":\\s+");
            String word = tokens[0];
            String def = tokens[1];

            if (!words.containsKey(word)) {
                words.put(word, new ArrayList<>());
                words.get(word).add(def);
            } else {
                words.get(word).add(def);
            }
        }

        String[] wordsInDic = sc.nextLine().split("\\s+\\|\\s+");
        String option = sc.nextLine();

        switch (option) {
            case "End":
                for (String s : wordsInDic) {
                    if (words.containsKey(s)) {
                        System.out.println(s);
                        words.get(s).stream().sorted((d1, d2) -> {

                            return Integer.compare(d2.length(), d1.length());
                        }).forEach(e -> System.out.println(String.format(" -%s",
                                e.replaceAll("[\\[\\]]", ""))));
                    }
                }

                break;
            case "List":
                List<String> keys = new ArrayList<>(words.keySet());
                System.out.println(keys.toString().replaceAll("[\\[\\],]", ""));
                break;
        }
    }
}
