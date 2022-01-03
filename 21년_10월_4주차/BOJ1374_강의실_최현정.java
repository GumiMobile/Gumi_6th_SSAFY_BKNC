import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 강의실
 * https://www.acmicpc.net/problem/1374
 */

public class Q1374 {
    private static Lecture[] lectures;
    private static PriorityQueue<Lecture> pq;

    static class Lecture implements Comparable<Lecture> {
        int num, start, end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (start != o.start) return start - o.start;
            return end - o.end;
        }
    }

    private static int solve(Lecture[] arr) {
        for (Lecture lecture : arr) {
            if (pq.isEmpty()) {
                pq.offer(lecture);
                continue;
            }

            assert pq.peek() != null;
            int currentEnd = pq.peek().end;
            int nextStart = lecture.start;

            if (currentEnd <= nextStart) {
                pq.poll();
            }
            pq.offer(lecture);
        }
        return pq.size();
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        lectures = new Lecture[n];
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(num, start, end);
        }
        Arrays.sort(lectures);

        br.close();
    }


    public static void main(String[] args) throws Exception {
        input();
        System.out.println(solve(lectures));
    }
}
