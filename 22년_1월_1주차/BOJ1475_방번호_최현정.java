import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 방 번호
 * https://www.acmicpc.net/problem/1475
 */

public class Q1475 {
    private static int[] numbersCount = new int[11];
    private static String N;
    private static int maxNumOfSets;

    private static void countSets() {
        int sum = numbersCount[6] + numbersCount[9];

        if (sum % 2 == 0) {
            numbersCount[6] = sum / 2;
            numbersCount[9] = sum / 2;
        } else {
            numbersCount[6] = sum / 2 + 1;
            numbersCount[9] = sum / 2 + 1;
        }

        for (int count : numbersCount) maxNumOfSets = Math.max(maxNumOfSets, count);

        System.out.println(maxNumOfSets);
    }

    // int 배열로 변경 및 숫자 몇번씩 나오는지 체크
    private static void convertToInt(char[] rooms) {
        for (int i = 0; i < rooms.length; i++) numbersCount[rooms[i] - '0']++;
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        convertToInt(N.toCharArray());
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        countSets();
    }
}
