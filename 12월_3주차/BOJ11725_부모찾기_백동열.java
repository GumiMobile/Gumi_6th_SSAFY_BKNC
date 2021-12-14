package algorithm_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11725_부모찾기_백동열 {

    private static int N;
    private static LinkedList<Integer> arr[];
    private static int result[];
    private static int answer;
    private static boolean visited[];

    private static void dfs(int start, int parent) {
        result[start] = parent;
        for (int item : arr[start]) {
            if (item != parent) {
                dfs(item, start);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new LinkedList[N + 1];
        result = new int[N + 1];

        for (int i = 1 ; i <= N; i++) {
            arr[i] = new LinkedList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }


        dfs(1, 0);

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }

    }
}
