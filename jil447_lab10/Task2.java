package lab10;

public class Task2 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        printArrayElements(arr,7);
    }
public static void printArrayElements(int a[], int index) {
        if (index!=-1) {
            printArrayElements(a,index-1);
            System.out.println(a[index]);
        }
    }
}

