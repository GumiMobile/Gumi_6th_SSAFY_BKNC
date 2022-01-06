package algorithm_220106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966_프린터큐_백동열 {

    private static int T;
    private static int N;
    private static int M;

    private static class Pair {
        private int num;
        private int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            ArrayList<Pair> arr_list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr_list.add(new Pair(Integer.parseInt(st.nextToken()), i));
            }

            Queue<Pair> q = new LinkedList<>();

            if (arr_list.size() > 1) {
                while (0 < arr_list.size()) {
                    Pair p = arr_list.get(0);
                    boolean check = false;

                    for (int j = 1; j < arr_list.size(); j++) {
                        if (p.num < arr_list.get(j).num) {
                            arr_list.remove(0);
                            arr_list.add(new Pair(p.num, p.index));
                            check = true;
                            break;
                        }
                    }

                    if (check) {
                        continue;
                    } else {
                        q.add(arr_list.get(0));
                        arr_list.remove(0);
                    }
                }

                int index = 1;

                while(!q.isEmpty()) {
                    Pair p = q.poll();

                    if (M == p.index) {
                        System.out.println(index);
                        break;
                    } else {
                        index++;
                    }
                }

            } else {
                System.out.println(1);
            }

        }

    }
}
