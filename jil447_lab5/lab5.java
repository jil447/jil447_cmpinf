package jil447_lab5;
import java.util.Random;
import java.util.Scanner;
public class lab5 {

    private static int[] counter;

      public lab5() {
          counter = new int[11];
    }
    public static void rollDice(int times, Random random) {
        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
        }

        int dice1 = 0;
        int dice2 = 0;
        int sum = 0;

        for (int count = 1; count <= times; count++) {
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;
            sum = dice1 + dice2;
            counter[sum - 2] = counter[sum - 2] + 1;
            System.out.println(String.format("%-4s%10s", "", ""));
        }
        for (int i = 0; i < counter.length; i++) {
            System.out.println(String.format("%-4d%-10.4f", i + 2, counter[i]*1.0 / times));
        }
    }
    public static void main(String[] args) {

        lab5 trial = new lab5();
        Random random = new Random();

        while (true) {
            System.out.print("Enter how many times you want to run:");
            java.util.Scanner scanner = new Scanner(System.in);
            int times = scanner.nextInt();
            trial.rollDice(times, random);
            System.out.print("Play again?");
            scanner.nextLine();
            if (scanner.nextLine().equals("yes")) {
                continue;
            } else {
                break;
            }
        }
    }
}