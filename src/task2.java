import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.comparingInt;

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
       /* for (int i = 0; i < arr2.length-1; i++) {
            for (int j = 0; j < arr2.length-i-1; j++) {
                int sumArr1 = 0;
                int sumArr2 = 0;

                for(int a = 0; a < arr2[j].length; a++) {
                    sumArr1 += arr2[j][a];
                }

                for(int b = 0; b < arr2[j+1].length; b++) {
                    sumArr2 += arr2[j+1][b];
                }

                if (sumArr1 < sumArr2) {
                    int[] temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                }
            }
        }*/
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < k; j++){
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
                arr[i][j] = RandomRange(3, 5);
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