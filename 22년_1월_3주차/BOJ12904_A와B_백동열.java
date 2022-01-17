package algorithm_220117;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ12904_A와B_백동열 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer S = new StringBuffer(br.readLine());
        StringBuffer T = new StringBuffer(br.readLine());

        while (S.length() < T.length()) {
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            } else if (T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        int answer = S.toString().equals(T.toString()) ? 1 : 0;
        System.out.println(answer);


    }
}
