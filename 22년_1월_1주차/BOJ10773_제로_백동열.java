package Algorithm_2022.algorithm_0105;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ10773_제로_백동열 {

    private static int K;
    private static ArrayList<Integer> num_list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        num_list = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                sum += num;
                num_list.add(num);
            } else {
                if (num_list.size() != 0) {
                    sum -= num_list.get(num_list.size() - 1);
                    num_list.remove(num_list.size() - 1);
                }
            }
        }

        System.out.println(sum);

    }
}
