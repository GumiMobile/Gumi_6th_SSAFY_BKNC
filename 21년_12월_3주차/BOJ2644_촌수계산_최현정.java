import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 촌수계산
 * https://www.acmicpc.net/problem/2644
 */

public class Q2644 {

    private static int n, startPerson, endPerson, m;
    private static ArrayList<Integer>[] adj;
    private static int[] degree;

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) degree[i] = -1;

        queue.offer(startPerson);
        degree[startPerson] = 0; // startPerson을 -1이 아닌 0(촌)으로 바꿔줌

        while (!queue.isEmpty()) {
            int person = queue.poll();

            for (int x : adj[person]) {
                if (degree[x] != -1) continue;

                queue.offer(x);
                degree[x] = degree[person] + 1;
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        degree = new int[n + 1];

        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        startPerson = Integer.parseInt(st.nextToken());
        endPerson = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
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
        System.out.println(degree[endPerson]);
    }
}
