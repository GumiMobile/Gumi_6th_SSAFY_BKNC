package ssafy.string02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1221. [S/W 문제해결 기본] 5일차 - GNS
 */

class Q1221 {
    private static int N;
    private static int[] countOfNum;
    private static String[] numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder answer;

    private static void output() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < countOfNum[i]; j++) answer.append(numbers[i]).append(" ");
        }
    }

    private static void input() throws Exception {
        System.setIn(new FileInputStream("src/ssafy/string02/res/input1221.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String TC = st.nextToken(); // #1
            N = Integer.parseInt(st.nextToken());
            countOfNum = new int[10];
            st = new StringTokenizer(br.readLine());
            answer = new StringBuilder();

            for (int i = 0; i < N; i++) {
                String gns = st.nextToken();
                for (int j = 0; j < 10; j++) {
                    if (gns.equals(numbers[j])) {
                        countOfNum[j]++; // countOfNum[n] => n의 개수
                        break;
                    }
                }
            }
            output();
            sb.append(TC).append("\n").append(answer).append("\n");
        }
    }

    public static void main(String args[]) throws Exception {
        input();
        System.out.println(sb.toString());

    }
}
