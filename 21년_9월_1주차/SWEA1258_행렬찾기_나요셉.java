package com.ssafy.algorithm.d0903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Point implements Comparable {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Object o) {
		Point p = (Point) o;
		
		int sizeA = this.x * this.y;
		int sizeB = p.x * p.y;
		
		// 크기에 따라 정렬
		if (sizeA > sizeB) return 1;
		else if (sizeA < sizeB) return -1;
		else {
			// 같을 경우 행에 따라 정렬
			if (this.x > p.x) return 1;
			else if (this.x < p.x) return -1;
			return 0;
		}
	}
}

public class SWEA1258_행렬찾기_나요셉 {
	static int N;
	static int arr[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	static List<Point> p;
	static Queue<Point> q;
	static List<Point> lst;
	
	// bfs
	public static void bfs(int x, int y) {
		p = new ArrayList<Point>();
		q = new LinkedList<Point>();
		
		p.add(new Point(x, y));
		q.offer(new Point(x, y));
		arr[x][y] = 0;
		
		while (!q.isEmpty()) {
			Point v = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int xx = v.x + dx[i];
				int yy = v.y + dy[i];
				
				if (xx < 0 || xx >= N || yy < 0 || yy >= N) continue;
				
				if (arr[xx][yy] != 0) {
					p.add(new Point(xx, yy)); // 선택된 좌표 모두 저장
					q.offer(new Point(xx, yy));
					arr[xx][yy] = 0;
				}
			}
		}
		
		// 시작지점과 도착지점
		Point start = p.get(0);
		Point end = p.get(p.size() - 1);
		
		lst.add(new Point(end.x - start.x + 1, end.y - start.y + 1)); // 전체 저장소에 저장
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			lst = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 0) bfs(i, j); // 0 이 아닌 좌표 bfs 
				}
			}
			
			Collections.sort(lst);
			
			sb.append("#").append(tc).append(" ").append(lst.size()).append(" ");
			for(Point l: lst) sb.append(l.x).append(" ").append(l.y).append(" ");
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
