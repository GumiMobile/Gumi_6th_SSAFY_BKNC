package ssafy.dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1258. [S/W 문제해결 응용] 7일차 - 행렬찾기
 */

public class Q1258 {
    private static int N;
    private static int[][] grid;
    private static List<Chemical> chemicals;
    private static int minX, minY, maxX, maxY;
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder answer = new StringBuilder();

    static class Chemical implements Comparable<Chemical> {
        int size, row, col;

        public Chemical(int size, int row, int col) {
            this.size = size;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Chemical o) {
            // 크기 순 정렬, 크기가 같으면 행이 작은순
            if (size != o.size) return size - o.size;
            return row - o.row;
        }
    }

    private static void bfs(int x, int y) {
        grid[x][y] = 0;
        minX = x; minY = y;
        maxX = x; maxY = y;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && grid[nx][ny] != 0) {
                    minX = Math.min(minX, nx); maxX = Math.max(maxX, nx);
                    minY = Math.min(minY, ny); maxY = Math.max(maxY, ny);
                    grid[nx][ny] = 0;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        int row = maxX - minX + 1;
        int col = maxY - minY + 1;
        chemicals.add(new Chemical(row * col, row, col));
    }

    private static void solve() {
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) bfs(i, j);
            }
        }

        Collections.sort(chemicals);
        sb.append(chemicals.size()).append(" ");
        for (Chemical ch : chemicals) {
            sb.append(ch.row).append(" ").append(ch.col).append(" ");
        }
    }

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/ssafy/dp/res/input1258.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            grid = new int[N][N];

            chemicals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) grid[i][j] = Integer.parseInt(st.nextToken());
            }
            solve();
            answer.append("#").append(test_case).append(" ").append(sb).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(answer.toString());
    }
}
