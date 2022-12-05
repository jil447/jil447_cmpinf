package lab10;

public class Task1 {
    public static int sumOfDigits(int x){
        if(x<0){
            return sumOfDigits(-x);
        }else if(x<=9){
            return x;
        }else{
            return sumOfDigits(x/10) + (x%10);
        }
    }
    public static void main(String[] args) {
        System.out.println(sumOfDigits(234));
        System.out.println(sumOfDigits(12));
        System.out.println(sumOfDigits(39));
        System.out.println(sumOfDigits(-12));
    }
}

