import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer> sequence = new ArrayList<>();
    static List<Integer> subSeq = new ArrayList<>();
    static int idx = 0;

    public static int find(int target) {
        int left = 1;
        int right = idx;

        while (left < right) {
            int mid = (left + right) / 2;

            if (target > subSeq.get(mid)) {
                left = mid + 1;
            } else if (target < subSeq.get(mid)) {
                right = mid;
            } else {
                left = mid;
                right = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());

        while (token.hasMoreTokens()) {
            sequence.add(Integer.parseInt(token.nextToken()));
        }

        subSeq.add(0);
        for (int n : sequence) {
            if (n > subSeq.get(idx)) {
                subSeq.add(n);
                idx += 1;
            } else {
                subSeq.set(find(n), n);
            }
        }

        System.out.println(idx);
    }
}