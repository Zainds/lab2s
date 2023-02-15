import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingDouble;

public class task2 {
    public static int RandomRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static void delete0rows(int[][] arr, int n, int k){
        int rows = 0;
        for (int i = 0; i<n; i++){
            int multilp = 1;
            for (int j = 0; j<k; j++){
                multilp *= arr[i][j];
            }
            if (multilp != 0) rows +=1;
        }
        int[][] arr2 = new int[rows][k];
        int rowback = 0;
        for (int i = 0; i<n; i++){
            int multilp = 1;
            for (int j = 0; j<k; j++){
                multilp *= arr[i][j];
            }
            if (multilp != 0){
                for (int j = 0; j<k; j++){
                    arr2[i + rowback][j] = arr[i][j];
                }
            }
            else rowback -=1;
        }
        Arrays.sort(arr2, comparingDouble(row -> IntStream.of(row)
                .average()
                .getAsDouble()));
        for (int i = rows-1; i >= 0; i--){
            for (int j = k-1; j >= 0; j--){
                System.out.print("   " + arr2[i][j]);
            }
            System.out.println();
        }

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
                arr[i][j] = RandomRange(2, 5);
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
        delete0rows(arr2, n, k);


    }
}
//