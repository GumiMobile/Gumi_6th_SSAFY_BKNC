import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286_절댓값힙_백동열 {
	
	private static int N;
	
	static class Pair implements Comparable<Pair> {
		
		private int abs;
		private int num;
		
		public Pair(int abs, int num) {
			this.abs = abs;
			this.num = num;
		}

		public int getAbs() {
			return abs;
		}

		public int getNum() {
			return num;
		}


		@Override
		public int compareTo(Pair pair) {
			if (this.abs == pair.abs) {
				return this.num > pair.num ? 1 : -1;
			}
			return this.abs - pair.abs;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input != 0) {
				pq.add(new Pair(Math.abs(input), input));
			} else {
				if (pq.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(pq.poll().num);
				}
			}
			
		}
		
		
		
	}

}
