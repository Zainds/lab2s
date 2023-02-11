import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class task2 {
    public static int RandomRange(int min, int max){
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return randomNum;
    }
    public static void main(String[] args){
        int n, k;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        int[][] arr = new int[n][k];
        int[][] arr2 = new int[n][k];
        for (int i = 0; i< n; i++){
            int flag = 1;
            for (int j = 0; j< k; j++){
                arr[i][j] = RandomRange(1, 5);
                System.out.print("   " + arr[i][j]);
                if (arr[i][j]<4)flag = 0;
            }
            System.out.println();
            if (flag == 1){
                for (int j = 0; j< k; j++) {
                    arr2[i][j] = arr[i][j];
                }
            }
        }
        System.out.println();
        for (int i = 0; i< n; i++){
            for (int j = 0; j< k; j++){
                System.out.print("   " + arr2[i][j]);
            }
            System.out.println();

        }
    }
}
//