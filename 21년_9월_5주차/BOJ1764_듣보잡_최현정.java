import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 듣보잡
 * https://www.acmicpc.net/problem/1764
 */

public class Q1764 {
    private static int n, m;
    private static Map<String, Integer> map = new HashMap<>();
    private static ArrayList<String> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    private static void solution() {
        for (String key : map.keySet()) {
            if (map.get(key) == 2) list.add(key);
        }

        list.sort(Comparator.naturalOrder());
        sb.append(list.size()).append("\n");

        for (String name : list) sb.append(name).append("\n");
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        solution();
        br.close();
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());
    }
}
