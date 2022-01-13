package algorithm_220112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1946_신입사원_백동열 {

    private static int T;
    private static int N;
    private static int arr[];


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            N = Integer.parseInt(br.readLine());

            arr = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                arr[first] = second;
            }

            int temp = arr[1];
            int answer = 1;

            for (int i = 2; i <= N; i++) {
                if (temp >= arr[i]) {
                    temp = arr[i];
                    answer++;
                }
            }

            System.out.println(answer);

        }
    }
}
