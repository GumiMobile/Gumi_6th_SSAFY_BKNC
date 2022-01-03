from sys import stdin, maxsize
import heapq
input = stdin.readline
INF = maxsize


def dijkstra(graph, start):
    distance[start] = 0
    heap = []
    heapq.heappush(heap, [distance[start], start])

    while heap:
        weight, vertex = heapq.heappop(heap)

        if distance[vertex] < weight:  # 현재 위치까지 오는 거리가 가중치보다 작을 경우 검사할 필요 없음
            continue

        for new_vertex, new_weight in graph[vertex]:
            w = weight + new_weight
            if w < distance[new_vertex]:
                distance[new_vertex] = w
                heapq.heappush(heap, [w, new_vertex])


N, M, K, start = map(int, input().split())
graph = {i: [] for i in range(1, N+1)}
distance = [INF] * (N + 1)

for _ in range(M):
    s, e = map(int, input().split())
    graph[s].append((e, 1))

dijkstra(graph, start)

res = []
for i in range(1, N + 1):
    if distance[i] == K:
        res.append(i)

if not res:
    print(-1)
else:
    for n in res:
        print(n)