package lab2;
import java.util.*;

public class Decomposing {
	public static void main(String[] args) {
		System.out.println("Input amount of money: ");
		Scanner scan = new Scanner(System.in);
		
		int num, a1, a2, a3, b1, b2, b3;
		num = scan.nextInt();
		a1 = num % 1000;
		b1 = num / 1000;
		a2 = a1 % 100;
		b2 = a1 / 100;
        a3 = a2 % 10;
		b3 = a2 / 10;
		scan.close();
		
		System.out.println(b1 + " Grands");
		System.out.println(b2 + " Benjamins");
		System.out.println(b3 + " sawbucks");
		System.out.println(a3 + " bucks");
	}
}
