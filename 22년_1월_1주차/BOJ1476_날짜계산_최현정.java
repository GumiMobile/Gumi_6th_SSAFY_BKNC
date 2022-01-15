import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 날짜 계산
 * https://www.acmicpc.net/problem/1476
 */

public class Q1476 {

    private static int E, S, M;

    private static void solution() {
        E -= 1; S -= 1; M -= 1;

        for (int i = 0; ; i++) {
            if (i % 15 == E && i % 28 == S && i % 19 == M) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
}
