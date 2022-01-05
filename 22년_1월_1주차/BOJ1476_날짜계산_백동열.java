package Algorithm_2022.algorithm_0104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476_날짜계산_백동열 {

    private static int E;
    private static int S;
    private static int M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int e = 1;
        int s = 1;
        int m = 1;

        int cnt = 1;
        while (true) {

            if (e == E) {
                if (s == S) {
                    if (m == M) {
                        break;
                    }
                }
            }

            if (e == 15) {
                e = 1;
            } else {
                e++;
            }
            if (s == 28) {
                s = 1;
            } else {
                s++;
            }
            if (m == 19) {
                m = 1;
            } else {
                m++;
            }

            cnt++;
        }

        System.out.println(cnt);

    }

}
