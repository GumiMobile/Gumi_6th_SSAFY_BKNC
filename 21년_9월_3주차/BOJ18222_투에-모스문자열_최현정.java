import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 투에-모스 문자열
 * https://www.acmicpc.net/problem/18222
 */

public class Q18222 {
    private static long N;

    private static long rec(long k) {
        if (k == 0) return 0;
        if (k == 1) return 1;
        if (k % 2 != 0) return 1 - rec(k / 2);
        else return rec(k / 2);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(rec(N - 1));
    }
}
