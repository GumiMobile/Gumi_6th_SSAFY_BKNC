import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 가지수
        int k = Integer.parseInt(st.nextToken()); // 연속으로 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 써서 공짜로 먹는 메뉴

        arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(twoPointer(n, k, c, d));
    }

    static int twoPointer(int N, int K, int coupon, int kinds) {
        int cnt = 0, maxCnt = 0;
        int[] visited = new int[kinds + 1];

        for (int i = 0; i < K; i++) { // 처음 K 크기의 윈도우 생성
            if (visited[arr[i]] == 0) {
                ++cnt;
            }
            ++visited[arr[i]];
        }

        maxCnt = cnt;

        for (int i = 1; i < N; i++) {
            if (maxCnt <= cnt) {
                if (visited[coupon] == 0) { // 쿠폰으로 먹을 수 있는 메뉴를 안 먹었을 경우
                    maxCnt = cnt + 1;
                } else {
                    maxCnt = cnt;
                }
            }

            --visited[arr[i - 1]];
            if (visited[arr[i - 1]] == 0)
                --cnt;

            if (visited[arr[(i + K - 1) % N]] == 0)
                ++cnt;

            ++visited[arr[(i + K - 1) % N]];
        }
        return maxCnt;
    }
}