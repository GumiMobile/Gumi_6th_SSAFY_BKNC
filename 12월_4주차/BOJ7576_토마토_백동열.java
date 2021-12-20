package algorithm_1220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576_토마토_백동열 {

    private static int N;
    private static int M;
    private static int arr[][];
    private static boolean visited[][];
    private static int result;
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, -1, 0, 1};
    private static boolean impossible;
    private static Queue<Pair> q;

    private static class Pair {
        private int x;
        private int y;
        private int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }

    private static void bfs() {

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;

            result = result < cnt ? cnt : result;

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (visited[nx][ny] == true)
                    continue;
                if (arr[nx][ny] == 1 || arr[nx][ny] == -1)
                    continue;

                visited[nx][ny] = true;
                arr[nx][ny] = 1;
                q.add(new Pair(nx, ny, cnt + 1));
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        result = 0;
        impossible = false;
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        q.add(new Pair(i, j, 0));
                    }
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    impossible = true;
                }
            }
        }

        if (impossible == true) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }
}
