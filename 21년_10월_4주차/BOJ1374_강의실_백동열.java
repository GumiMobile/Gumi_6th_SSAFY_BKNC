import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1374_강의실_백동열 {

	
	private static int N;
	private static ArrayList<Pair> arr_list;
	
	static class Pair implements Comparable<Pair>{
		int num;
		int start;
		int end;
		
		public Pair(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Pair p) {
			return this.start - p.start;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N = Integer.parseInt(br.readLine());
		
		arr_list = new ArrayList<Pair>();
		
		for (int i = 0 ; i < N; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr_list.add(new Pair(num, start, end));
			
		}
		
		Collections.sort(arr_list);
		
		int max = Integer.MIN_VALUE;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			while (!pq.isEmpty() && pq.peek() <= arr_list.get(i).start) {
				pq.poll();
			}
			pq.add(arr_list.get(i).end);
			max = max < pq.size() ? pq.size() : max;
		}
	
		System.out.println(max);
		
	}
	
}
