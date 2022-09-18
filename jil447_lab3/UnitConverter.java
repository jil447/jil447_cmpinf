package jil447_lab3;

import java.util.Scanner;

public class UnitConverter {
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num = sc.nextDouble();
        String str1 = sc.next();
        

        if (str1.equals("cm")) {
        	double in = num * 0.3937;
        	double yd = num * 0.010936133;
        	double m = num / 1000;
        	
        	System.out.println(in + " in");
        	System.out.println(yd + " yd");
        	System.out.println(m +  " m");
        	
        }else if(str1.equals("in")) {
        	double yd = num * 0.02778;
        	double m = num * 0.0254;
        	double cm = num * 2.54;
        	
        	System.out.println(cm + " cm");
        	System.out.println(m + " m");
        	System.out.println(yd + " yd");
        	
        }else if(str1.equals("m")) {
        	double in = num * 39.3701;
        	double yd = num * 1.0936;
        	double cm = num * 1000;
        	
        	System.out.println(in + " in");
        	System.out.println(yd + " yd");
        	System.out.println(cm + " cm");
        	
        }else if(str1.equals("oz")) {
        	double gm = num * 28.3495;
        	double lb = num * 0.0625;
        	double kg = num * 0.02835;
        	
        	System.out.println(gm + " gm");
        	System.out.println(lb + " lb");
        	System.out.println(kg + " kg");
        	
        }else if(str1.equals("gm")) {
        	double oz = num * 0.0353;
        	double lb = num * 0.0022;
        	double kg = num * 0.001;
        	
        	System.out.println(oz + " oz");
        	System.out.println(lb + " lb");
        	System.out.println(kg + " kg");
        	
        }else if(str1.equals("lb")) {
        	double oz = num * 16;
        	double gm = num * 453.5924;
        	double kg = num * 0.4536;
        	
        	System.out.println(oz + " oz");
        	System.out.println(gm + " gm");
        	System.out.println(kg + " kg");
        
        }else {
        	System.out.println("False Input");
        
        sc.close();

    }
}
}
