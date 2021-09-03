from collections import deque

def bfs(x, y, visited):
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    queue = deque()
    queue.append([x, y])
    visited[x][y] = True

    minX, maxX = x, x
    minY, maxY = y, y
    while queue:
        sx, sy = queue.popleft()
        for i in range(4):
            ax = sx + dx[i]
            ay = sy + dy[i]

            if 0 <= ax < N and 0 <= ay < N and not visited[ax][ay]:
                if matrix[ax][ay] > 0:
                    minX = min(minX, ax)
                    maxX = max(maxX, ax)
                    minY = min(minY, ay)
                    maxY = max(maxY, ay)
                    visited[ax][ay] = True
                    queue.append([ax, ay])

    # 행의 크기 : 최대 행 - 최소 행 + 1, 열의 크기 : 최대 열 - 최소 열 + 1, 넓이 return
    return [maxX - minX + 1, maxY - minY + 1, (maxX - minX + 1) * (maxY - minY + 1)]



T = int(input())
for t in range(1, T+1):
    N = int(input())
    matrix = [list(map(int, input().split())) for _ in range(N)]

    ans = 0
    res = []

    # BFS로 행렬 탐색
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and matrix[i][j] != 0:
                res.append(bfs(i, j, visited))

    # 넓이 순으로, 넓이가 같을 땐 행이 작은 순서대로 정렬
    res = sorted(res, key=lambda x : (x[2], x[0]))

    print(f'#{t} {len(res)}', end=" ")
    for x, y, area in res:
        print(x, y, end=" ")
    print()