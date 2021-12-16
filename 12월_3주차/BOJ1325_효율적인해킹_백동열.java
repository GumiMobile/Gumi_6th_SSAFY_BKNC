package algorithm_1216;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1325_효율적인해킹_백동열 {

    private static int N;
    private static int M;
    private static Node arr[];
    private static boolean visited[];
    private static int num[];

    private static class Node {

        int index;
        ArrayList<Node> nodes;

        public Node(int index) {
            this.index = index;
            this.nodes = new ArrayList<>();
        }
    }

    private static void dfs(int start, int current) {

        for (Node node : arr[current].nodes) {
            if (visited[node.index] == false) {
                visited[node.index] = true;
                dfs(start, node.index);
                num[start]++;
            }
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Node[N + 1];
        num = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b].nodes.add(arr[a]);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, i);
        }

        for (int i = 1; i <= N; i++) {
            max = Math.max(max, num[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (max == num[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);

    }
}
