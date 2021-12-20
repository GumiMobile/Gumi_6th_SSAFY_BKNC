package algorithm_1220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667_단지번호붙이기_백동열 {

    private static int N;
    private static char arr[][];
    private static int total;
    private static int dx[] = {1, 0, -1, 0};
    private static int dy[] = {0, -1, 0, 1};
    private static boolean visited[][];
    private static ArrayList<Integer> num_list;

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static void bfs(int a, int b) {

        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(a, b));
        int cnt = 1;

        while(!q.isEmpty()) {

            int x = q.peek().x;
            int y = q.peek().y;

            q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (visited[nx][ny] == true)
                    continue;
                if (arr[nx][ny] == '0')
                    continue;

                visited[nx][ny] = true;
                cnt++;
                q.add(new Pair(nx, ny));
            }

        }

        num_list.add(cnt);

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N];
        num_list = new ArrayList<>();
        total = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '1') {
                    if (visited[i][j] == false) {
                        visited[i][j] = true;
                        total++;
                        bfs(i, j);
                    }
                }
            }
        }

        System.out.println(total);
        num_list.sort(null);

        for (int i = 0; i < num_list.size(); i++) {
            System.out.println(num_list.get(i));
        }

    }
}
