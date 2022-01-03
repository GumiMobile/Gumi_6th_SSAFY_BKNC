package algorithm_1221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질_백동열 {

    private static int N;
    private static int K;
    private static int move[] = {-1, 1, 2};
    private static int min;
    private static boolean visited[];

    private static class Pair {
        private int point;
        private int cnt;

        public Pair(int point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }

    }

    private static void bfs() {

        Queue<Pair> q = new LinkedList<Pair>();

        visited[N] = true;
        q.add(new Pair(N, 0));

        while(!q.isEmpty()) {

            int n = q.peek().point;
            int cnt = q.peek().cnt;

            q.remove();

            if (n == K) {
                min = cnt;
                break;
            }

            for (int i = 0; i < 3; i++) {
                int next = n;
                if (i == 2) {
                    next *= move[i];
                } else {
                    next += move[i];
                }

                if (next < 0 || next > 100000)
                    continue;
                if (visited[next] == true)
                    continue;

                visited[next] = true;
                q.add(new Pair(next, cnt + 1));
            }

        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        visited = new boolean[100001];

        bfs();

        System.out.println(min);

    }
}
