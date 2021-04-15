import java.util.*;

public class Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String message = scan.nextLine();

        TreeMap<String, List<Integer>> account = new TreeMap<>();
        TreeMap<String, Integer> checking = new TreeMap<>();

        int followers = 0;
        while (!message.equals("Log out")) {
            String[] tokens = message.split(": ");

            switch ((tokens[0])) {
                case "New follower":
                    String username = tokens[1];
                    if (account.containsKey(username)) {
                        break;
                    } else {
                        account.put(username, new ArrayList<>());
                        followers++;
                        // група  индекс 0 за likes
                        account.get(username).add(0, 0);

                        // група индекс 1 за comments
                        account.get(username).add(1, 0);

                    }
                    break;
                case "Like":
                    String likeUserName = tokens[1];
                    int countLike = Integer.parseInt(tokens[2]);

                    if (!account.containsKey(likeUserName)) {
                        account.put(likeUserName, new ArrayList<>());
                        followers++;

                        account.get(likeUserName).add(0, countLike);
                        // група индекс 1 за comments
                        account.get(likeUserName).add(0, 0);
                    } else {
                        int oldSum = account.get(likeUserName).get(0);
                        account.get(likeUserName).set(0, oldSum + countLike);
                    }
                    break;
                case "Comment":
                    String userComment = tokens[1];

                    if (!account.containsKey(userComment)) {
                        account.put(userComment, new ArrayList<>());
                        followers++;

                        account.get(userComment).add(0, 0);
                        // група индекс 1 за comments
                        account.get(userComment).add(1, 1);
                    } else {
                        int numberComments = account.get(userComment).get(1);
                        account.get(userComment).set(1, numberComments + 1);
                    }
                    break;

                case "Blocked":
                    String blockedUser = tokens[1];

                    if (account.containsKey(blockedUser)) {
                        account.remove(blockedUser);
                        followers--;
                        break;
                    } else {
                        System.out.printf("%s doesn't exist.", blockedUser);
                    }
            }
            message = scan.nextLine();
        }

        System.out.printf("%d followers%n", followers);

        for (Map.Entry<String, List<Integer>> entry : account.entrySet()) {

            int n1 = entry.getValue().get(0);
            int n2 = entry.getValue().get(1);
            int sum = (n1 + n2);

            checking.putIfAbsent(entry.getKey(), sum);
        }
        checking.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));
    }
}
