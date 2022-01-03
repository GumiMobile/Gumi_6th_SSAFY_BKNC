package ssafy.problem0906;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4008. [모의 SW 역량테스트] 숫자 만들기
 */

public class Q4008 {
    private static int N, max, min;
    private static int[] nums, operators, order;
    private static StringBuilder sb = new StringBuilder();

    private static int calculate() {
        int value = nums[1];
        for (int i = 1; i <= N; i++) {
            if (order[i] == 1) value += nums[i + 1];
            if (order[i] == 2) value -= nums[i + 1];
            if (order[i] == 3) value *= nums[i + 1];
            if (order[i] == 4) value /= nums[i + 1];
        }
        return value;
    }

    private static void rec_func(int k) {
        if (k == N) {
            int value = calculate();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 1; i <= 4; i++) {
                if (operators[i] > 0) {
                    operators[i]--;
                    order[k] = i;
                    rec_func(k + 1);
                    operators[i]++;
                    order[k] = 0;
                }
            }
        }
    }

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/ssafy/problem0906/res/input4008.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            nums = new int[N + 1];
            operators = new int[5];
            order = new int[N + 1];
            min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 4; i++) operators[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

            rec_func(1);
            sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
        }
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
