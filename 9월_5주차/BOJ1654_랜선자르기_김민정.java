import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void find(List<Integer> cables, int N) {
        long left = 1;
        long right = Collections.max(cables);

        long res = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int cable : cables) {
                cnt += (cable / mid);
            }

            if (cnt >= N) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        List<Integer> cables = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            cables.add(Integer.parseInt(br.readLine()));
        }

        find(cables, N);
    }
}