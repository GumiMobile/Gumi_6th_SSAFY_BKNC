package com.js.pekah.algorithms.d0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 20:45 ~ 

class XYZ {
	int x, y, z;
	
	public XYZ(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class BOJ7569_토마토_나요셉 {
	static int N;
	static int M;
	static int H;
	static int arr[][][];
	static int visited[][][];
	static int result;
	static int dx[] = {-1, 1, 0, 0, 0, 0};
	static int dy[] = {0, 0, -1, 1, 0, 0};
	static int dz[] = {0, 0, 0, 0, 1, -1};
	static Queue<XYZ> q = new LinkedList<XYZ>();
	
	public static void tomato() {
		
		while(!q.isEmpty()) {
			XYZ v = q.poll();
			
			for (int i = 0; i < 6; i++) {
				int xx = v.x + dx[i];
				int yy = v.y + dy[i];
				int zz = v.z + dz[i];
				
				if (xx < 0 || xx >= N || yy < 0 || yy >= M || zz < 0 || zz >= H) continue;
				if (arr[zz][xx][yy] == 0 && visited[zz][xx][yy] == 0) {
					q.add(new XYZ(xx, yy, zz));
					visited[zz][xx][yy] = visited[v.z][v.x][v.y] + 1; 
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];
		visited = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int tomato = Integer.parseInt(st.nextToken());
					arr[i][j][k] = tomato;
					
					if (arr[i][j][k] == 1) q.add(new XYZ(j, k, i));
				}
			}
		}
		
		tomato();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (result < visited[i][j][k])
						result = visited[i][j][k];
				}
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 0 && visited[i][j][k] == 0)
						result = -1;
				}
			}
		}
		
		System.out.println(result);
	}
}
