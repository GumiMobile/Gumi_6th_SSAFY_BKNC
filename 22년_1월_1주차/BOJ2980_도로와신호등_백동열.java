package Algorithm_2022.algorithm_0103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2980_도로와신호등_백동열 {

    private static int N;
    private static int L;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int time = 0;
        int pre = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            time += d - pre;
            pre = d;

            int red = time % (r + g);
            if (red <= r) {
                time += r - red;
            }
        }

        System.out.println(time + (L - pre));

    }


}
