import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int min_ind = -999;
        double sr = 0; int k = 0;
        int[] arr = new int[n];
        System.out.println("Enter day temperature");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i ++){
            arr[i] = in.nextInt();
            if (min_ind < arr[i]){
                min_ind = i;
            }
        }
        for (int i = 0; i<= min_ind; i++){
            sr += arr[i];
            k++;
        }
        System.out.println(sr/k);

    }
}