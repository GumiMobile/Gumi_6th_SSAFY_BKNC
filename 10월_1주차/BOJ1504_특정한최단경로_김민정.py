from sys import stdin, maxsize
import heapq
input = stdin.readline
INF = maxsize


def dijkstra(graph, start):
    distance = [INF] * (N + 1)
    distance[start] = 0

    heap = []
    heapq.heappush(heap, [distance[start], start])

    while heap:
        weight, nxt = heapq.heappop(heap)

        if distance[nxt] < weight:
            continue

        for new_vtx, new_wgt in graph[nxt]:
            w = weight + new_wgt
            if w < distance[new_vtx]:
                distance[new_vtx] = w
                heapq.heappush(heap, [w, new_vtx])

    return distance


N, E = map(int, input().split())
graph = {i: [] for i in range(1, N + 1)}

for _ in range(E):
    s, e, v = map(int, input().split())
    graph[s].append((e, v))
    graph[e].append((s, v))

v1, v2 = map(int, input().split())

starting = dijkstra(graph, 1)
v1_path = dijkstra(graph, v1)
v2_path = dijkstra(graph, v2)

res = min(starting[v1] + v1_path[v2] + v2_path[N], starting[v2] + v2_path[v1] + v1_path[N])
print(res if res < INF else -1)