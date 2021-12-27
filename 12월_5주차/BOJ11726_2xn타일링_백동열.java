package algorithm_1227;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11726_2xn타일링_백동열 {

    private static int N;
    private static int dp[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        if (N < 3) {
            System.out.println(N);
        } else {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= N; i++)
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;

            System.out.println(dp[N]);
        }
    }
}
