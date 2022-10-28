package jil447_lab7;

	import java.util.Scanner;
	import java.util.Random;
	public class Lab7 {

	    public static double max(double[] data) {
	        double max = data[0];
	        for (int i = 0; i < data.length; i++) {
	            max = Math.max(max, data[i]);
	        }
	        return max;
	    }
	    public static double min(double[] data) {
	        double min = data[0];
	        for (int i = 0; i < data.length; i++) {
	            min = Math.min(min, data[i]);;
	        }
	        return min;
	    }
	    public static double sum(double[] data) {
	        double sum = 0;
	        for (int i = 0; i < data.length; i++) {
	            sum += data[i];
	        }
	        return sum;
	    }

	    public static double average(double[] data) {

	        double sum;
	        sum = sum(data);
	        return sum / data.length;
	    }


	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("How many elements do you want to enter : ");
	        int n = sc.nextInt();
	        double data[] = new double[n];
	        Random a = new Random();
	        for (int i = 0; i < data.length; i++)
	            data[i]=a.nextDouble();
	        System.out.print("Array elements : ");
	        for (int i = 0; i < data.length; i++) {
	            System.out.print(data[i] + " ");
	        }
	        System.out.println("\nmax is : " + max(data));
	        System.out.println("min is :" + min(data));
	        System.out.println("sum is : " + sum(data));
	        System.out.println("average is :" + average(data));
	    }
	}


