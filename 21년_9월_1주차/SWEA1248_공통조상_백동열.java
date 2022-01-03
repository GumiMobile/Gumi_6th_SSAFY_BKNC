import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 공통조상 {
	
	static int V;
	static int E;
	static int num1;
	static int num2;
	static boolean visited[];
	static Node nodes[];
	static int n;
	
	static void get(Node node) {
		n++;
		if (node.l != 0) {
			get(nodes[node.l]);
		}
		if (node.r != 0) {
			get(nodes[node.r]);
		}
	}

	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int result[][] = new int[T + 1][2];
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			
			nodes = new Node[V + 1];
			visited = new boolean[V + 1];
			n = 0;
			
			for (int i = 1; i <= V; i++) {
				nodes[i] = new Node(i);
			}
			
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < E; i++) {
				int p = Integer.parseInt(st2.nextToken());
				int c = Integer.parseInt(st2.nextToken());
				
				if (nodes[p].l == 0) {
					nodes[p].l = c;
				} else {
					nodes[p].r = c;
				}
				nodes[c].p = p;
			}
			
			
			int parent = 1;
			
			while(true) {
				
				if (num1 != 1) {
					int pa = nodes[num1].p;
					
					if (visited[pa] == true) {
						parent = pa;
						break;
					}
					visited[pa] = true;
					num1 = pa;
				}
				
				if (num2 != 1) {
					int pb = nodes[num2].p;
					
					if (visited[pb] == true) {
						parent = pb;
						break;
					}
					visited[pb] = true;
					num2 = pb;
				}
				
			}
			get(nodes[parent]);
			

			result[test_case][0] = parent;
			result[test_case][1] = n;

		}
		
		for (int i = 1; i <= T; i++) {
			System.out.print("#" + i + " " + result[i][0] + " " + result[i][1]);
			System.out.println();
		}
		
		
	}
	
}


class Node {
	int data;
	int p;
	int l;
	int r;
	
	public Node(int data) {
		this.data = data;
		this.p = 0;
		this.l = 0;
		this.r = 0;
	}
	
	
}
