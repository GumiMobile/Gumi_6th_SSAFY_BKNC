from sys import stdin, maxsize
import heapq
input = stdin.readline
INF = maxsize


def dijkstra(graph, start):
    distance = {node: INF for node in range(1, V+1)}
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

    return distance


V, E = map(int, input().split())
K = int(input())

graph = {i: [] for i in range(1, V+1)}

for _ in range(E):
    s, e, v = map(int, input().split())
    graph[s].append([e, v])

res = dijkstra(graph, K)
for i in range(1, V+1):
    if res[i] == INF:
        print("INF")
    else:
        print(res[i])