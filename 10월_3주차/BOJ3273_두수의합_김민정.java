import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        System.out.println(twoPointer(n, x));
    }

    static int twoPointer(int N, int M) {
        int cnt = 0, sum = 0;
        int start = 0, end = N - 1;

        while (start < end) {
            sum = arr[start] + arr[end];
            if (sum == M) {
                ++cnt;
            }

            if (sum <= M) {
                ++start;
            } else {
                --end;
            }
        }

        return cnt;
    }
}
