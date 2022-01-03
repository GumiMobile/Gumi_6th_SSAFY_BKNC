package algorithm_1224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707_이분그래프_백동열 {

    private static int K;
    private static int V;
    private static int E;
    private static ArrayList<Integer> arr_list[];
    private static int arr[];
    private static int visited[];


    private static void bfs() {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()) {
                int current = q.poll();

                for (int j = 0; j < arr_list[current].size(); j++) {
                    if (visited[arr_list[current].get(j)] == 0) {
                        q.add(arr_list[current].get(j));
                    }
                    if (visited[arr_list[current].get(j)] == visited[current]) {
                        System.out.println("NO");
                        return;
                    }

                    if (visited[current] == 1 && visited[arr_list[current].get(j)] == 0)
                        visited[arr_list[current].get(j)] = 2;
                    else if (visited[current] == 2 && visited[arr_list[current].get(j)] == 0)
                        visited[arr_list[current].get(j)] = 1;
                }


            }
        }

        System.out.println("YES");
        return;

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < K; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            arr_list = new ArrayList[V + 1];
            visited = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                arr_list[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                arr_list[u].add(v);
                arr_list[v].add(u);
            }

            bfs();

        }


    }
}
