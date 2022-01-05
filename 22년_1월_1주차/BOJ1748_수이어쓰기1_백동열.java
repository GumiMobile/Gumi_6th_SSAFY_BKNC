package Algorithm_2022.algorithm_0105;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1748_수이어쓰기1_백동열 {

    private static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int len = String.valueOf(N).length();
        int temp = N;
        int sum = 0;

        for (int i = len; i > 0; i--) {
            int num_len = (int) Math.pow(10, i - 1);
            int num = temp - num_len;
            sum += (num + 1) * i;
            temp -= (num + 1);
        }
        System.out.println(sum);

    }
}
