package algorithm_220111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1052_물병_백동열 {

    private static int N;
    private static int K;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N <= K) {
            System.out.println(0);
            return;
        }

        int answer = 0;
        int cnt = 0;

        while(true) {
            cnt = 0;
            int temp = N;

            while (temp != 0) {
                if (temp % 2 == 1) {
                    cnt++;
                }
                temp /= 2;
            }
            if (cnt <= K)
                break;
            N += 1;
            answer += 1;

        }

        System.out.println(answer);

    }
}
