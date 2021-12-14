package algorithm_1214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012_유기농배추_백동열 {

    private static int T;
    private static int M, N, K;
    private static int arr[][];
    private static boolean visited[][];
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, -1, 0, 1};
    private static int count;

    private static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (visited[nx][ny] == true) {
                continue;
            }
            if (arr[nx][ny] != 1) {
                continue;
            }

            visited[nx][ny] = true;
            dfs(nx, ny);

        }

        return;


    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            count = 0;

            arr = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }


            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == false && arr[i][j] == 1) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);



        }


    }
}
