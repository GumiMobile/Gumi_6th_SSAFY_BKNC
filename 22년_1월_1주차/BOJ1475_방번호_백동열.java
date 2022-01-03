package Algorithm_2022.algorithm_0103;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1475_방번호_백동열 {

    private static String N;
    private static int arr[];


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = br.readLine();
        arr = new int[11];

        for (int i = 0; i < N.length(); i++) {
            arr[Integer.parseInt(String.valueOf(N.charAt(i)))] += 1;
        }

        int max = 0;
        int three_nine = 0;
        for (int i = 0; i <= 10; i++) {
            if (i != 6 && i != 9) {
                max = Math.max(max, arr[i]);
            } else {
                three_nine += arr[i];
            }
        }

        if (three_nine % 2 == 0) {
            three_nine /= 2;
        } else {
            three_nine /= 2;
            three_nine++;
        }

        if (max < three_nine) {
            max = three_nine;
        }

        System.out.println(max);

    }


}
