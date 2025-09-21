import java.util.Random;
import java.util.Scanner;

public class VoidChamber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int bullet = random.nextInt(5) + 1;
        String dash = "-".repeat(40);
        int totalShotsFired = 0;
        int userScore = 0;
        String strUserSelection = "";

        while (totalShotsFired != 5 && !strUserSelection.equalsIgnoreCase("X")) {
            try {
                // "Clear" screen (simulated with new lines)
                System.out.println("\n".repeat(10));
                System.out.println(dash);
                System.out.println("     ⟁⟟⋏ ⍙⍜⋔⟒    Void Chamber     ⟁⟟⋏ ⍙⍜⋔⟒     ");
                System.out.println(dash);
                System.out.println("Cycles Endured: " + totalShotsFired + " | Shards: ⏁" + userScore);
                System.out.println(dash);
                System.out.println("( T ): Summon the Chambers Call");
                System.out.println("( P ): Each refusal feeds the Voids hunger.");
                System.out.println("( X ): Your essence scatters into the dark.");
                System.out.print("Selection:  ");
                strUserSelection = scanner.nextLine().trim();

                if (strUserSelection.equalsIgnoreCase("T")) {
                    int userShot = random.nextInt(5) + 1;
                    int computersShot = random.nextInt(5) + 1;

                    if (userShot == bullet) {
                        System.out.println("\nYOU ARE DEAD!\n");
                        totalShotsFired = 0;
                    } else {
                        totalShotsFired++;
                        userScore += 100;

                        if (computersShot == bullet) {
                            System.out.println("Computer Lost!");
                            System.out.print("(Y) for Yes or (N) for No: ");
                            String cont = scanner.nextLine().trim();
                            if (cont.equalsIgnoreCase("Y")) {
                                totalShotsFired = 0;
                                userScore += 100;
                            } else {
                                strUserSelection = "X";
                            }
                        }
                    }

                } else if (strUserSelection.equalsIgnoreCase("P")) {
                    userScore -= 10;
                    int computersShot = random.nextInt(5) + 1;

                    if (computersShot == bullet) {
                        System.out.println("You Won!");
                        System.out.print("(Y) for Yes or (N) for No: ");
                        String cont = scanner.nextLine().trim();
                        if (cont.equalsIgnoreCase("Y")) {
                            totalShotsFired = 0;
                            userScore += 100;
                        } else {
                            strUserSelection = "X";
                        }
                    } else {
                        totalShotsFired++;
                        System.out.println("Choose Again.\n");
                    }

                } else {
                    strUserSelection = "X";
                    System.out.println("\nDeath comes for all.......");
                }

            } finally {
                if (totalShotsFired == 5) {
                    System.out.println("Gun is Dry, Congrats you survived!");
                    System.out.print("New game? (Y/N): ");
                    String cont = scanner.nextLine().trim();
                    if (cont.equalsIgnoreCase("Y")) {
                        totalShotsFired = 0;
                        bullet = random.nextInt(5) + 1; // reset bullet
                    } else {
                        strUserSelection = "X";
                    }
                }
            }
        }
        scanner.close();
    }
}
