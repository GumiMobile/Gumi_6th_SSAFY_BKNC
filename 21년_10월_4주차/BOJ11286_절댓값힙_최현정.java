import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 절댓값 힙
 * https://www.acmicpc.net/problem/11286
 */

public class Q11286 {
    private static int n;
    private static PriorityQueue<int[]> pq;
    private static StringBuilder sb = new StringBuilder();

    private static void solve(int num) {
        if (num == 0) {
            if (!pq.isEmpty()) {
                int[] x = pq.poll();
                if (x[0] == 0) sb.append((-1) * x[1]).append("\n");
                else sb.append(x[1]).append("\n");
            } else sb.append(num).append("\n");

        }
        // 정수 num이 음수이면 {0, num}, 양수이면 {1, num}으로 pq에 넣음
        else {
            if (num < 0) pq.offer(new int[]{0, Math.abs(num)});
            else pq.offer(new int[]{1, num});
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 절댓값이 가장 작은 값이 여러개일 때는 가장 작은 수 출력
        pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            solve(num);
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
