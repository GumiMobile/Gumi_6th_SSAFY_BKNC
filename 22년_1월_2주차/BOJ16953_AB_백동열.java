package algorithm_220113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953_AB_백동열 {

    private static int A;
    private static int B;
    private static int answer;

    private static void dfs(long num, int cnt) {

        if (num == B) {
            answer = cnt;
            return;
        } else if (num > B) {
            return;
        }

        String snum = String.valueOf(num);

        dfs(Long.parseLong(snum) * 2, cnt + 1);
        dfs(Long.parseLong(snum + "1"), cnt + 1);
    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        answer = 0;

        dfs(A, 0);

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer + 1);
        }

    }
}
