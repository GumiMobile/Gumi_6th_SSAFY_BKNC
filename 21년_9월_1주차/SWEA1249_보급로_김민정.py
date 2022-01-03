from collections import deque

# 다익스트라 알고리즘
def dijkstra(queue):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    while queue:
        y, x = queue.popleft()
        for i in range(4):  # BFS로 그래프 탐색
            ay = y + dy[i]
            ax = x + dx[i]

            if 0 <= ay < N and 0 <= ax < N:
                if distance[ay][ax] > distance[y][x] + graph[ay][ax]:  # 현재 가중치보다 작을 때
                    distance[ay][ax] = distance[y][x] + graph[ay][ax]
                    queue.append((ay, ax))


T = int(input())
for t in range(1, T + 1):
    N = int(input())
    graph = [list(map(int, list(input()))) for _ in range(N)]

    INF = float('inf')
    distance = [[INF] * N for _ in range(N)]
    distance[0][0] = 0

    queue = deque()
    queue.append((0, 0))
    dijkstra(queue)

    print(f'#{t} {distance[N-1][N-1]}')