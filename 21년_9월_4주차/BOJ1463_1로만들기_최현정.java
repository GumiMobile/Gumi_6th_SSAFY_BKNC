import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 * https://www.acmicpc.net/problem/1463
 */

public class Q1463 {
    private static int N;
    private static int[] d;

    private static int solution(int n) {
        if (n == 1) return 0;
        if (d[n] > 0) return d[n];
        d[n] = solution(n - 1) + 1;
        if (n % 3 == 0) {
            int count = solution(n / 3) + 1;
            if (d[n] > count) d[n] = count;
        }
        if (n % 2 == 0) {
            int count = solution(n / 2) + 1;
            if (d[n] > count) d[n] = count;
        }
        return d[n];
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[N + 1];
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(solution(N));
    }
}
