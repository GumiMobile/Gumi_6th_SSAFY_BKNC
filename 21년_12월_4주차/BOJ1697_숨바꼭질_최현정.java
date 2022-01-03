import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 * https://www.acmicpc.net/problem/1697
 */

public class Q1697 {

    private static int N, K;
    private static Queue<Integer> queue = new LinkedList<>();
    private static int[] seconds;
    private static boolean[] visited;

    private static void bfs() {
        queue.add(N);
        visited[N] = true;
        seconds[N] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x - 1 >= 0 && !visited[x - 1]) {
                visited[x - 1] = true;
                seconds[x - 1] = seconds[x] + 1;
                queue.add(x - 1);
            }
            if (x + 1 <= 100_000 && !visited[x + 1]) {
                visited[x + 1] = true;
                seconds[x + 1] = seconds[x] + 1;
                queue.add(x + 1);
            }
            if (x * 2 <= 100_000 && !visited[x * 2]) {
                visited[x * 2] = true;
                seconds[x * 2] = seconds[x] + 1;
                queue.add(x * 2);
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        seconds = new int[100_001];
        visited = new boolean[100_001];

        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        bfs();
        System.out.println(seconds[K]);
    }
}
