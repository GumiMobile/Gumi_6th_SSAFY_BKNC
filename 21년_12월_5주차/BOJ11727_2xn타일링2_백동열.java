package algorithm_1228;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11727_2xn타일링2_백동열 {

    private static int N;
    private static int dp[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[1001];

        if (N == 2) {
            System.out.println(3);
        } else if (N == 1) {
            System.out.println(1);
        } else {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 3;

            for (int i = 3; i <= N; i++)
                dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

            System.out.println(dp[N]);
        }

    }

}
