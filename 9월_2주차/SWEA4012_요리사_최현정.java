package ssafy.problem0907;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4012. [모의 SW 역량테스트] 요리사
 */

public class Q4012 {
    private static int N, min, A, B;
    private static int[][] foods;
    private static int[] selected;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    private static void getTaste() {
        A = 0; B = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j]) A += foods[i - 1][j - 1] + foods[j - 1][i - 1];
                else if (!visited[i] && !visited[j]) B += foods[i - 1][j - 1] + foods[j - 1][i - 1];
            }
        }
        int result = Math.abs(A - B);
        min = Math.min(result, min);
    }

    private static void rec_func(int k) {
        if (k == N / 2 + 1) getTaste();
        else {
            for (int i = selected[k - 1] + 1; i <= N; i++) {
                selected[k] = i;
                visited[i] = true;
                rec_func(k + 1);
                selected[k] = 0;
                visited[i] = false;
            }
        }
    }

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/ssafy/problem0907/res/input4012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            foods = new int[N][N];
            min = Integer.MAX_VALUE;
            selected = new int[N / 2 + 1];
            visited = new boolean[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) foods[i][j] = Integer.parseInt(st.nextToken());
            }
            rec_func(1);
            sb.append("#").append(test_case).append(" ").append(min).append("\n");
        }
        br.close();
    }

    public static void main(String args[]) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
