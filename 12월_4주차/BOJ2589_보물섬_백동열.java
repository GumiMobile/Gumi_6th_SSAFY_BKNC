package algorithm_1223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2589_보물섬_백동열 {

    private static int N;
    private static int M;
    private static char arr[][];
    private static boolean visited[][];
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, -1, 0, 1};
    private static int total_max;

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

    private static int bfs(int a, int b) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(a, b, 0));
        int max = 0;

        while(!q.isEmpty()) {

            Pair p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (arr[nx][ny] != 'L')
                    continue;
                if (visited[nx][ny] == true)
                    continue;

                max = Math.max(max, p.cnt);
                visited[nx][ny] = true;
                q.add(new Pair(nx, ny, p.cnt + 1));
            }
        }

        return max;

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        total_max = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    visited = new boolean[N][M];
                    visited[i][j] = true;
                    int temp = bfs(i, j);
                    if (total_max <= temp) {
                        total_max = temp;
                    }
                }
            }
        }

        System.out.println(total_max + 1);

    }
}
