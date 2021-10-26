import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heapq = new PriorityQueue<>((n1, n2) -> {
            int abs1 = Math.abs(n1);
            int abs2 = Math.abs(n2);

            if (abs1 == abs2) return n1 > n2 ? 1 : -1;
            return abs1 - abs2;
        });

        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd != 0) {
                heapq.add(cmd);
            } else {
                if (heapq.isEmpty())
                    System.out.println("0");
                else {
                    System.out.println(heapq.poll());
                }
            }
        }
    }
}