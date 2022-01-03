import java.io.*;
import java.util.*;

public class Main {
    
    public static class Lecture {
        int classNum;
        int start;
        int end;

        Lecture() {}

        Lecture (int classNum, int start, int end) {
            this.classNum = classNum;
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heapq = new PriorityQueue<>();
        Comparator<Lecture> comparator = new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return Integer.compare(o1.start, o2.start);
            }
        };
        
        List<Lecture> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int classNum = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lecture(classNum, start, end));
        }

        Collections.sort(list, comparator);
        
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            while (!heapq.isEmpty() && heapq.peek() <= list.get(i).start) {
                heapq.poll();
            }
            
            heapq.add(list.get(i).end);
            max = Math.max(max, heapq.size());
        }

        System.out.println(max);
    }
}