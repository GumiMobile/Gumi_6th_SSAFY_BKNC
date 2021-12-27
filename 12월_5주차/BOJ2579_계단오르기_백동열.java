package algorithm_1227;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2579_계단오르기_백동열 {

    private static int N;
    private static int arr[];
    private static int dp[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N < 2) {
            System.out.println(arr[N]);
        } else {
            dp[0] = 0;
            dp[1] = arr[1];
            dp[2] = dp[1] + arr[2];

            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
            }

            System.out.println(dp[N]);
        }

    }
}
