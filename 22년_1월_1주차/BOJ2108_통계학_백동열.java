package Algorithm_2022.algorithm_0104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ2108_통계학_백동열 {

    private static int N;
    private static int arr[];
    private static ArrayList<Integer> mid_list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[8001];
        mid_list = new ArrayList<>();

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }

            arr[num + 4000]++;

            mid_list.add(num);
            sum += num;
        }

        int max_cnt = 0;
        int index = 0;
        for (int i = 0; i <= 8000; i++) {
            if (max_cnt < arr[i]) {
                max_cnt = arr[i];
                index = i;
            }
        }

        ArrayList<Integer> max_list = new ArrayList<>();
        int second_min = 0;
        for (int i = 0; i <= 8000; i++) {
            if (max_cnt == arr[i]) {
                max_list.add(i);
            }
        }

        max_list.sort(null);

        if (max_list.size() >= 2) {
            second_min = max_list.get(1);
        } else {
            second_min = max_list.get(0);
        }

        second_min -= 4000;

        mid_list.sort(null);

        int mid = mid_list.get((mid_list.size() / 2));
        int diff = max - min;


        System.out.println((int) Math.round((double)sum / N));
        System.out.println(mid);
        System.out.println(second_min);
        System.out.println(diff);




    }

}
