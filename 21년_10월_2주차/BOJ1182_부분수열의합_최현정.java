import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 부분수열의 합
 * https://www.acmicpc.net/problem/1182
 */

public class Q1182 {
    private static int N, S, sum;
    private static int[] nums;

    private static void rec_func(int k, int num) {
        if (k == N) {
            if (num == S) sum++;
        } else {
            rec_func(k + 1, num + nums[k]);
            rec_func(k + 1, num);
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        rec_func(0, 0);
        if (S == 0) sum--;
        System.out.println(sum);
    }
}
