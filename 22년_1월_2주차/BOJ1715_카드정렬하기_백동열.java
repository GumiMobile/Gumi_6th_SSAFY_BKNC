package algorithm_220114;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715_카드정렬하기_백동열 {

    private static int N;
    private static PriorityQueue<Long> pq;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long sum = 0;
        while(pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();

            sum += num1 + num2;
            pq.add(num1 + num2);
        }

        System.out.println(sum);

    }
}
