import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 * https://www.acmicpc.net/problem/7569
 */

public class Q7569 {
    private static int M;
    private static int N;
    private static int H;
    private static int[][][] tomatoes;
    private static boolean[][][] visited;
    private static Queue<int[]> queue;
    private static int[][] dirs = {
            {0, 0, -1},
            {0, 0, 1},
            {-1, 0, 0},
            {1, 0, 0},
            {0, -1, 0},
            {0, 1, 0}};

    // 토마토가 익지 못하는 상황이면 -1, 아니면 몇일 걸리는지 리턴
    private static int checkTomatoes() {
        int days = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 0) return -1;
                    days = Math.max(days, tomatoes[i][j][k]);
                }
            }
        }
        return days - 1;
    }

    // 저장될 때 부터 모든 토마토가 익어있는 상태인지 확인
    private static boolean checkTomatoesAll() {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int[] dir : dirs) {
                int dh = point[0] + dir[0];
                int dn = point[1] + dir[1];
                int dm = point[2] + dir[2];

                if (dh >= 0 && dh < H && dn >= 0 && dn < N && dm >= 0 && dm < M && tomatoes[dh][dn][dm] == 0 && !visited[dh][dn][dm]) {
                    visited[dh][dn][dm] = true;
                    queue.offer(new int[]{dh, dn, dm});
                    tomatoes[dh][dn][dm] = tomatoes[point[0]][point[1]][point[2]] + 1;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomatoes = new int[H][N][M];
        visited = new boolean[H][N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        input();
        if (checkTomatoesAll()) System.out.println(0);
        else {
            bfs();
            System.out.println(checkTomatoes());
        }
    }

    private static void print(int[][][] arr) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
