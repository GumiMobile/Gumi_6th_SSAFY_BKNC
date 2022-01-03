import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer(n, k));
    }

    static int twoPointer(int N, int M) {
        int cnt = 1, sum = arr[0], maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0;

        while (end < N) {
            if (cnt == M) {
                maxSum = Math.max(maxSum, sum);
                --cnt;
                sum -= arr[start++];
            } else {
                ++end;
                if (end < N) {
                    sum += arr[end];
                }
                ++cnt;
            }
        }

        return maxSum;
    }
}