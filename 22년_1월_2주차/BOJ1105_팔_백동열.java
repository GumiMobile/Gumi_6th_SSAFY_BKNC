package algorithm_220111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1105_팔_백동열 {

    private static String L;
    private static String R;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = st.nextToken();
        R = st.nextToken();

        if (L.length() != R.length()) {
            System.out.println(0);
        } else {
            int cnt = 0;
            for (int i = 0; i < L.length(); i++) {
                if (L.charAt(i) != R.charAt(i)) {
                    break;
                } else if (L.charAt(i) == R.charAt(i) && L.charAt(i) == '8') {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }



    }
}
