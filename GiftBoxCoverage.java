import java.util.Scanner;

public class GiftBoxCoverage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double sizeSide = Double.parseDouble(scan.nextLine());
        double numberSheet = Double.parseDouble(scan.nextLine());

        double sm = Double.parseDouble(scan.nextLine());

        double sizeGift = sizeSide * sizeSide * 6;

        double cover = Math.floor(numberSheet / 3);
        double leftCover = numberSheet - cover;

        double tableCover = leftCover * sm;
        double tableLeftCover = cover * (sm * 0.25);

        double table = tableCover + tableLeftCover;

        double finale = (table / sizeGift) * 100;
        System.out.println(String.format("You can cover %.2f%% of the box.", finale));
    }
}
