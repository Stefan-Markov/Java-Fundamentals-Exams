import java.util.Scanner;

public class ExperienceGaining {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double experience = Double.parseDouble(scan.nextLine());
        int countOfBattles = Integer.parseInt(scan.nextLine());

        int counter = 0;
        double earnedXp = 0;
        for (int i = 1; i <= countOfBattles; i++) {
            if (earnedXp >= experience) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", counter);
                return;
            }
            double xpPerBattle = Double.parseDouble(scan.nextLine());

            if (i % 3 != 0 && i % 5 != 0) {
                earnedXp += xpPerBattle;
                counter++;

            } else if (i % 3 == 0) {
                earnedXp += xpPerBattle * 1.15;
                counter++;
            } else {
                earnedXp += xpPerBattle * 0.9;
                counter++;
            }
        }

        if (experience > earnedXp) {
            double diff = experience - earnedXp;
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", diff);
        } else if (earnedXp > experience) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", counter);
        }
    }
}
