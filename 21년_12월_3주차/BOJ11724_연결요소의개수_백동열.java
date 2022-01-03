package algorithm_1216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724_연결요소의개수_백동열 {

    private static int N;
    private static int M;
    private static int arr[][];
    private static int cnt;
    private static boolean visited[];

    private static void dfs(int current) {

        visited[current] = true;

        for (int i = 1; i <= N; i++) {
            if (arr[current][i] == 1) {
                if (visited[i] == false) {
                    visited[i] = true;
                    dfs(i);
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        cnt = 0;
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                cnt++;
                dfs(i);
            }
        }


        System.out.println(cnt);

    }
}
