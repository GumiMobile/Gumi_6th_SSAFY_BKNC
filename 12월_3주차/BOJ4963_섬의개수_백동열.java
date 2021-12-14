package algorithm_1214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963_섬의개수_백동열 {

    private static int w;
    private static int h;
    private static int arr[][];
    private static boolean visited[][];
    private static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int count;

    private static void dfs(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
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

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        if (visited[i][j] == false) {
                            count++;
                            visited[i][j] = true;
                            dfs(i, j);
                        }
                    }
                }
            }

            System.out.println(count);
        }

    }
}
