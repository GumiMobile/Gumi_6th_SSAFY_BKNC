import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer(N, M));
    }

    static int twoPointer(int N, int M) {
        int cnt = 0, sum = arr[0];
        int start = 0, end = 0;

        while (start <= end && end < N) {
            if (sum < M) {
                ++end;
                if (end < N) {
                    sum+=arr[end];
                }
            } else if (sum == M) {
                ++cnt;
                ++end;
                if (end < N) {
                    sum+=arr[end];
                }
            } else {
                sum-=arr[start];
                ++start;
                if (start > end && start < N) {
                    end = start;
                    sum = arr[start];
                }
            }
        }

        return cnt;
    }
}