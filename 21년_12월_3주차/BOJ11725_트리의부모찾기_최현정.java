import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리의 부모 찾기
 * https://www.acmicpc.net/problem/11725
 */

public class Q11725 {

    private static int N;
    private static int[] parent;
    private static ArrayList<Integer>[] adj;
    private static boolean[] visited;
    private static final StringBuilder sb = new StringBuilder();

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            for (int x : adj[vertex]) {
                if (visited[x]) continue;

                queue.add(x);
                parent[x] = vertex;
                visited[x] = true;
            }
        }

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
    }


    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N ; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }

        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        bfs();
        System.out.println(sb);
    }
}
