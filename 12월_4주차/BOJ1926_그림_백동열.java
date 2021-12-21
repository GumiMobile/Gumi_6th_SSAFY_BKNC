package algorithm_1221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926_그림_백동열 {

    private static int n;
    private static int m;
    private static int arr[][];
    private static boolean visited[][];
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, -1, 0, 1};
    private static int land;
    private static int result;

    private static class Pair {

        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private static void bfs(int a, int b) {

        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(a, b));
        int cnt = 1;

        while(!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.peek().y;

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (visited[nx][ny] == true)
                    continue;
                if (arr[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                cnt++;
                q.add(new Pair(nx, ny));
            }

        }

        land = land < cnt ? cnt : land;

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        result = 0;
        land = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false) {
                    if (arr[i][j] == 1) {
                        result++;
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }
        }

        System.out.println(result);
        System.out.println(land);


    }
}
