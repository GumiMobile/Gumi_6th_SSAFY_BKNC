package ssafy.problem0908;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 7465. 창용 마을 무리의 개수
 */

public class Q7465 {
    private static int N, M, answer;
    private static boolean[] visited;
    private static int[][] people;
    private static StringBuilder sb = new StringBuilder();
    private static Queue<Integer> queue = new LinkedList<>();

    private static void bfs(int k) {
        queue.offer(k);
        visited[k] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (people[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/ssafy/problem0908/res/input7465.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 6
            M = Integer.parseInt(st.nextToken()); // 5
            answer = 0;
            visited = new boolean[N + 1];
            people = new int[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                people[x][y] = 1;
                people[y][x] = 1;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    answer++;
                    bfs(i);
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        br.close();
    }

    public static void main(String args[]) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
