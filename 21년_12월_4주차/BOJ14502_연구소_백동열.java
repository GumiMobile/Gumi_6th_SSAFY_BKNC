package algorithm_1222;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소_백동열 {

    private static int N;
    private static int M;
    private static int arr[][];
    private static int temp[][];
    private static boolean visited[][];
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, -1, 0, 1};
    private static int result;

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static void setWall(int cnt) {

        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    temp[i][j] = 1;
                    setWall(cnt + 1);
                    temp[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {

        int virus_after[][] = new int[N][M];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virus_after[i][j] = temp[i][j];
                if (virus_after[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        while(!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.peek().y;

            q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;
                if (virus_after[nx][ny] != 0)
                    continue;

                virus_after[nx][ny] = 2;
                q.add(new Pair(nx, ny));
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virus_after[i][j] == 0) {
                    cnt++;
                }
            }
        }

        result = result < cnt ? cnt : result;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        arr = new int[N][M];
        temp = new int[N][M];
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < M; l++) {
                            temp[k][l] = arr[k][l];
                        }
                    }
                    temp[i][j] = 1;
                    setWall(1);
                    temp[i][j] = 0;
                }
            }
        }

        System.out.println(result);

    }
}
