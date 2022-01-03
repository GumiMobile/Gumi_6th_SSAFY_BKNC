import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 집합
 * https://www.acmicpc.net/problem/11723
 */

public class Q11723 {

    private static int N, bitset;
    private static StringBuilder sb = new StringBuilder();

    private static void bitMask(String operator, int num) {

        switch (operator) {
            case "add":
                bitset |= (1 << (num - 1));
                break;
            case "remove":
                bitset = bitset & ~(1 << (num - 1));
                break;
            case "check":
                sb.append((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                break;
            case "toggle":
                bitset ^= (1 << (num - 1));
                break;
            case "all":
                bitset |= (~0);
                break;
            case "empty":
                bitset &= 0;
                break;
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 26
        bitset = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();
            if (operator.equals("all") || operator.equals("empty"))
                bitMask(operator, -1);
            else {
                int num = Integer.parseInt(st.nextToken());
                bitMask(operator, num);
            }
        }

        br.close();
    }
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
