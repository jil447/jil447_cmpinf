package lab2;

import javax.swing.JOptionPane;

public class Pythagorean {
	public static void main(String[] arges) {
		String input = JOptionPane.showInputDialog("Input Side A£º");
		String input2 = JOptionPane.showInputDialog("Input Side B£º");
		
		int m = Integer.parseInt(input);
		int n = Integer.parseInt(input2);
        double result = Math.sqrt(Math.pow(m, 2) + Math.pow(n, 2));
        
        JOptionPane.showMessageDialog(null, "The hypotenuse is " + result);
        
	}
}