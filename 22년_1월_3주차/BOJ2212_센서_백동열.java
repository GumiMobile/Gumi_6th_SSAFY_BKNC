package algorithm_220120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2212_센서_백동열 {

    private static int N;
    private static int K;
    private static int arr[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (K >= N) {
            System.out.println(0);
        } else {
            Integer diff_arr[] = new Integer[N - 1];

            for (int i = 0; i < N - 1; i++) {
                diff_arr[i] = arr[i + 1] - arr[i];
            }

            Arrays.sort(diff_arr, Collections.reverseOrder());

            int sum = 0;
            for (int i = K - 1; i < N - 1; i++) {
                sum += diff_arr[i];
            }

            System.out.println(sum);
        }



    }
}
