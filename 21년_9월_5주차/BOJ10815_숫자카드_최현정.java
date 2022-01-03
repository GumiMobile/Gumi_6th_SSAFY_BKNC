import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 숫자 카드
 * https://www.acmicpc.net/problem/10815
 */

public class Q10815 {
    private static int N, M;
    private static int[] myNums, nums;
    private static StringBuilder sb = new StringBuilder();

    private static int binarySearch(int num, int L, int R) {
        while (L <= R) {
            int mid = (L + R) / 2;
            if (myNums[mid] < num) L = mid + 1;
            else if (myNums[mid] > num) R = mid - 1;
            else if (myNums[mid] == num) return 1;
        }
        return 0;
    }

    private static void solution() {
        Arrays.sort(myNums);
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(nums[i], 0, myNums.length - 1)).append(" ");
        }
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        myNums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) myNums[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) nums[i] = Integer.parseInt(st.nextToken());

        solution();

        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
