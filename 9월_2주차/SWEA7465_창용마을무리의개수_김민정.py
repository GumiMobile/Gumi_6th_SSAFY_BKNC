from collections import deque

def bfs(n):
    queue = deque()
    queue.append(n)

    while queue:
        node = queue.popleft()
        for n in relation[node]:
            if not visited[n]:
                visited[n] = True
                queue.append(n)


T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    relation = [[0]*(N+1) for _ in range(N+1)]
    visited = [False] * (N+1)

    for _ in range(M):
        f1, f2 = map(int, input().split())
        relation[f1].append(f2)

    cnt = 0
    for i in range(1, N+1):
        if not visited[i]:
            visited[i] = True
            bfs(i)
            cnt += 1

    print(f'#{t} {cnt}')