package algorithm_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2644_촌수계산_백동열 {

    private static int n;
    private static int a, b;
    private static int m;
    private static boolean arr[][];
    private static boolean visited[];
    private static int result;
    private static boolean findAnswer;

    private static void dfs(int current, int dest, int cnt) {

        visited[current] = true;

        if (current == dest) {
            result = cnt;
            findAnswer = true;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[current][i] == false) {
                continue;
            } else if (arr[current][i] == true && visited[i]) {
                continue;
            } else {
                dfs(i, dest, cnt + 1);
                if (findAnswer) break;
            }
        }

        return;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        result = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = true;
            arr[y][x] = true;
        }

        dfs(a, b, 0);

        System.out.println(result);

    }
}
