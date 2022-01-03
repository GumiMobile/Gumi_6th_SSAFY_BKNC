package ssafy.problem0909;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1767. [SW Test 샘플문제] 프로세서 연결하기
 */

public class Q1767 {
    private static int N, size, min;
    private static char[][] cells;
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static boolean[] visited;
    private static List<int[]> core;
    private static StringBuilder sb = new StringBuilder();

    private static void rec_func(int index, int count, int S) {
        if (count == S) {
            dfs(0, 0);
            return;
        } else {
            for (int i = index; i < size; i++) {
                visited[i] = true;
                rec_func(i + 1, count + 1, S);
                visited[i] = false;
            }
        }
    }

    private static void dfs(int index, int count) {
        if (index == core.size()) {
            min = Math.min(min, count);
            return;
        }

        if (!visited[index]) {
            dfs(index + 1, count);
            return;
        }

        for (int[] dir : dirs) {
            int x = core.get(index)[0];
            int y= core.get(index)[1];
            int lineCount = 0;
            boolean success = false;

            while (true) {
                x += dir[0]; y += dir[1];
                // 가장자리까지 갔으면 성공
                if (x < 0 || x >= N || y < 0 || y >= N) {
                    success = true;
                    break;
                }
                if (cells[x][y] != '0') break; // 전선이나 코어를 만난 경우
                cells[x][y] = 'X';
                lineCount++;
            }

            if (success) dfs(index + 1, count + lineCount);
            while (true) {
                x -= dir[0]; y -= dir[1];
                if (x == core.get(index)[0] && y == core.get(index)[1]) break;
                cells[x][y] = '0';
            }
        }
    }

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/ssafy/problem0909/res/input1767.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            cells = new char[N][N];
            min = Integer.MAX_VALUE;
            core = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cells[i][j] = st.nextToken().charAt(0);
                    if (cells[i][j] == '1' && i != 0 && j != 0 && i != N - 1 && j != N - 1)
                        core.add(new int[] {i, j});
                }
            }
            size = core.size();
            visited = new boolean[size];

            // 모든 코어에 전원이 연결되지 않을 경우가 존재하기 때문
            for (int i = size; i >= 0; i--) {
                rec_func(0, 0, i);
                if (min < Integer.MAX_VALUE) break;
            }

            sb.append("#").append(test_case).append(" ").append(min).append("\n");
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
