import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1655_가운데를말해요_백동열 {
	
	private static int N;
	private static PriorityQueue<Integer> min_pq;
	private static PriorityQueue<Integer> max_pq;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		min_pq = new PriorityQueue<Integer>();
		max_pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			
			int num = Integer.parseInt(br.readLine());
			
			if (max_pq.size() == min_pq.size()) {
				max_pq.add(num);
				
				if (!min_pq.isEmpty() && max_pq.peek() > min_pq.peek()) {
					min_pq.add(max_pq.poll());
					max_pq.add(min_pq.poll());
				}
			} else {
				min_pq.add(num);
				
				if (max_pq.peek() > min_pq.peek()) {
					min_pq.add(max_pq.poll());
					max_pq.add(min_pq.poll());
				}
			}
			
			sb.append(max_pq.peek() + "\n");
			
		}
		
		System.out.println(sb);
		
	}
}
