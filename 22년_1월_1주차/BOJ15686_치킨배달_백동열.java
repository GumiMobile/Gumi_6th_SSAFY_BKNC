package algorithm_220107;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686_치킨배달_백동열 {

    private static int N;
    private static int M;
    private static ArrayList<Pair> home_list;
    private static ArrayList<Pair> chicken_list;
    private static boolean open[];
    private static int answer;

    private static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static void dfs(int start, int cnt) {

        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < home_list.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken_list.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(home_list.get(i).x - chicken_list.get(j).x) + Math.abs(home_list.get(i).y - chicken_list.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            answer = Math.min(answer, res);
            return;
        }

        for (int i = start; i < chicken_list.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home_list = new ArrayList<>();
        chicken_list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) {
                    home_list.add(new Pair(i, j));
                } else if (num == 2) {
                    chicken_list.add(new Pair(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        open = new boolean[chicken_list.size()];

        dfs(0, 0);

        System.out.println(answer);

    }
}
