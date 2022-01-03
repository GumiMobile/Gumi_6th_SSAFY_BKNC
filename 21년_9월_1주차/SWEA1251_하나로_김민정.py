from collections import defaultdict
import heapq

T = int(input())
for t in range(1, T + 1):
    N = int(input())

    x_axis = list(map(int, input().split()))
    y_axis = list(map(int, input().split()))

    E = float(input())
    graph = defaultdict(list)

    # 입력값을 그래프로 표현
    for s in range(N):
        for e in range(N):
            if s != e:
                graph[s].append([e, (x_axis[s] - x_axis[e])**2 + (y_axis[s] - y_axis[e])**2])

    key = [float('inf')] * N
    mst = [False] * N
    heap = []

    # prim 알고리즘 - 0번째 노드에서부터 탐색
    key[0] = 0
    heapq.heappush(heap, (0, 0))  # heap에 정점과의 거리, 정점 순으로 삽입
    res = 0

    while heap:
        k, u = heapq.heappop(heap)

        if mst[u]:
            continue

        mst[u] = True
        res += k

        for dest, w in graph[u]:
            if not mst[dest] and w < key[dest]:
                key[dest] = w
                heapq.heappush(heap, (w, dest))

    print(f'#{t} {round(res*E)}')