import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int findNumber(int target, List<Integer> numCard) {
        int left = 0;
        int right = numCard.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (numCard.get(mid) == target)
                return 1;
            else if (numCard.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        List<Integer> numCard = new ArrayList<>();

        while(token.hasMoreTokens()) {
            numCard.add(Integer.parseInt(token.nextToken()));
        }

        Collections.sort(numCard);

        int M = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        token = new StringTokenizer(br.readLine());
        List<Integer> target = new ArrayList<>();

        while (token.hasMoreTokens()) {
            target.add(Integer.parseInt(token.nextToken()));
        }

        br.close();

        List<Integer> res = new ArrayList<>();

        for (int tNum : target) {
            res.add(findNumber(tNum, numCard));
        }

        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
