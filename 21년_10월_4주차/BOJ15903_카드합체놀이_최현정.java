import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 카드 합체 놀이
 * https://www.acmicpc.net/problem/15903
 */

public class Q15903 {
    private static int n, m;
    private static PriorityQueue<Long> pq;

    // sum에도 long을 해줘야 했던 것이었다..!
    private static long pqSum() {
        long sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        return sum;
    }

    private static void cardPlay() {
        long x = 0, y = 0;
        if (!pq.isEmpty()) x = pq.poll();
        if (!pq.isEmpty()) y = pq.poll();
        pq.offer(x + y);
        pq.offer(x + y);
    }

    private static void solve() {
        for (int i = 0; i < m; i++) {
            cardPlay();
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pq.offer(Long.parseLong(st.nextToken()));

        br.close();
    }
    public static void main(String[] args) throws Exception {
        input();
        solve();
        System.out.println(pqSum());
    }
}
