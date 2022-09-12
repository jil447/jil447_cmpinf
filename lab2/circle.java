package lab2;
import javax.swing.JOptionPane;

	public class circle{
		public static void main(String[] args) {

			String input = JOptionPane.showInputDialog("Input the radius£º");
			
			final double PI = 3.14159; 
			double m = Double.parseDouble(input);
			double area = PI*m*m;
			double length = 2*PI*m;
	        
	        JOptionPane.showMessageDialog(null, "The circle with radius " + m 
	        									+ " has an area of " + area
	        									+ " and a perimeter of "+ length );
		}
	}

