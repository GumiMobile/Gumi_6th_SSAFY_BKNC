import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        PriorityQueue<Long> heapq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heapq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = heapq.poll();
            long y = heapq.poll();

            long sum = x + y;
            heapq.add(sum);
            heapq.add(sum);
        }

        long total = 0;
        while (!heapq.isEmpty()) {
            total += heapq.poll();
        }

        System.out.println(total);
    }
}