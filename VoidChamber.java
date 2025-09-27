/*##############
    TO DO LIST :
##################*/

// implement the code snippet below to reduce the if/else statements into cleaner code
/* 

switch(expression)

{case value1:
// code block for value1
break;
case value2:
// code block for value2
break;
// ... more cases
default:
// code block if no case matches
}

*/

// Add other key functionality like data save, perk/bonuses etc...


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
                System.out.println(" ⟁⟟⋏ ⍙⍜⋔⟒  Void Chamber  ⟁⟟⋏ ⍙⍜⋔⟒  ");
                System.out.println(dash);
                System.out.println("Cycles Endured: " + totalShotsFired + " | Shards: ⏁  " + userScore);
                System.out.println(dash);
                System.out.println(" 1 : Summon the Chambers Call");
                System.out.println(" 2 : Pas..Each refusal feeds the Voids hunger.");
                System.out.println(" 3 : Your essence scatters into the dark.");
                System.out.print("Selection:  ");
                int UserSelection = scanner.nextInt();

                if (UserSelection == 1) {
                    int userShot = random.nextInt(5) + 1;
                    int computersShot = random.nextInt(5) + 1;

                    if (userShot == bullet) {
                        System.out.println("\nThe Void Has Claimed You.....!\n");
                        totalShotsFired = 0;
                    } else {
                        totalShotsFired++;
                        userScore += 100;

                        if (computersShot == bullet) {
                            System.out.println("The Chamber has broken.");
                            System.out.print("(Y) for Yes or (N) for No: ");
                            String cont = scanner.nextLine().trim();
                            if (cont.equalsIgnoreCase("Y")) {
                                totalShotsFired = 0;
                                userScore += 100;
                            } else {
                                UserSelection = 3;
                            }
                        }
                    }

                } else if (UserSelection == 2) {
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
                            UserSelection = 3;
                        }
                    } else {
                        totalShotsFired++;
                        System.out.println("Choose Again.\n");
                    }

                } else {
                    UserSelection = 3;
                    System.out.println("\nDeath comes for all.......");
                }

            } finally {
                if (totalShotsFired == 5) {
                    System.out.println("The Chamber is regenerating, Congrats you survived!");
                    System.out.print("New game? (Y/N): ");
                    String cont = scanner.nextLine().trim();
                    if (cont.equalsIgnoreCase("Y")) {
                        totalShotsFired = 0;
                        bullet = random.nextInt(5) + 1; // reset bullet
                    }
                }
            }
        }
        scanner.close();
    }
}

