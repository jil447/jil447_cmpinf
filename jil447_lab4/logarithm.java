package jil447_lab4;
import javax.swing.*;

public class logarithm {
    public static void main(String[] args) {
        String n1Str = JOptionPane.showInputDialog("Input the log");
        int X = Integer.parseInt(n1Str);
        String n2Str = JOptionPane.showInputDialog("Input the base");
        int b = Integer.parseInt(n2Str);

        int count = 0;

        if (X > 0 && b > 1) {
            while (X / b > b) {
                count++;
                X = X/b;
            }
            System.out.println("It takes " + count + " divisions for our quotient to be less than the base "
                    + b + " ,so the answer is " + count);
        }else{
            System.out.println("Please enters an valid number again");
        }

    }
}