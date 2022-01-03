package ssafy.graph;

import java.io.*;
import java.util.*;

/**
 * 1249. [S/W 문제해결 응용] 4일차 - 보급로
 */

public class Q1249 {
    private static int N; // 지도의 크기
    private static int[][] map;
    private static int[][] answer;
    private static int min;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static StringBuilder sb = new StringBuilder();

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            if(x == N - 1 && y == N - 1) min = Math.min(min, answer[N - 1][N - 1]);

            if (min <= answer[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (!visited[nx][ny] || (answer[nx][ny] > answer[x][y] + map[nx][ny])) {
                    visited[nx][ny] = true;
                    answer[nx][ny] = answer[x][y] + map[nx][ny];
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/ssafy/graph/res/input1249.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = new int[N][N];
            min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) Arrays.fill(answer[i], Integer.MAX_VALUE);
            answer[0][0] = 0;

            for (int i = 0; i < N; i++) {
                char[] strings = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) map[i][j] = strings[j] - '0';
            }

            bfs();
//            print2d(answer);
            sb.append("#").append(test_case).append(" ").append(min).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());
    }

    public static void print2d(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------");
    }
}