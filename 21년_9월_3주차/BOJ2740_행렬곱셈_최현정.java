import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 행렬 곱셈
 * https://www.acmicpc.net/problem/2740
 */

public class Q2740 {
    private static int[][] A, B, answer;
    private static int N, M, K;

    private static void multiple() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                for (int k = 0; k < M; k++) answer[i][j] += A[i][k] * B[k][j];
            }
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 행렬 A 입력
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 행렬 B 입력
        B = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) B[i][j] = Integer.parseInt(st.nextToken());
        }

        answer = new int[N][K];
        br.close();
    }

    public static void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        multiple();
        print(answer);
    }

}
