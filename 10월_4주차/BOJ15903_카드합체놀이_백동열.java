import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ15903_카드합체놀이_백동열 {
	
	private static int N;
	private static int M;
	private static PriorityQueue<Long> pq;
	
	private static long findMin() {
		
		long result = 0;
		
		int cnt = 0;
		while(cnt < M) {
			
			long first = pq.poll();
			long second = pq.poll();
			
			long sum = first + second;
			
			pq.add(sum);
			pq.add(sum);
			
			cnt++;
		}
		
		while(!pq.isEmpty()) {
			result += pq.poll();
		}
		
		return result;
		
	}
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<Long>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		long min = findMin();
		
		System.out.println(min);
	}
	
}
