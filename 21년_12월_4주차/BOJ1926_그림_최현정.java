import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그림
 * https://www.acmicpc.net/problem/1926
 */

public class Q1926 {

    private static int n, m, count, pictures, maxPicture;
    private static int[][] paper;
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || paper[i][j] != 1) return;
        paper[i][j] = -1; // 방문했다는 뜻
        pictures++;
        for (int [] dir : dirs) dfs(i + dir[0], j + dir[1]);
    }

    private static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (paper[i][j] == 1) {
                    count++;
                    dfs(i, j);
                    maxPicture = Math.max(maxPicture, pictures);
                    pictures = 0;
                }
            }
        }
        sb.append(count).append("\n").append(maxPicture);
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = 0;
        maxPicture = 0;
        paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) paper[i][j] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        solution();
        System.out.println(sb);
    }
}
