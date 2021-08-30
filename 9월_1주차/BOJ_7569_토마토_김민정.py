from sys import stdin
from collections import deque
input = stdin.readline

M, N, H = map(int, input().split())
box = []
queue = deque()
def bfs():
    dx = [0, 0, 1, 0, -1, 0] # 앞뒤
    dy = [0, 0, 0, 1, 0, -1] # 좌우
    dz = [1, -1, 0, 0, 0, 0] # 위아래

    while queue:
        sz, sx, sy = queue.popleft()
        for i in range(6):
            az = sz + dz[i]
            ax = sx + dx[i]
            ay = sy + dy[i]

            if 0 <= az < H and 0 <= ax < N and 0 <= ay < M and box[az][ax][ay] == 0:
                box[az][ax][ay] = box[sz][sx][sy] + 1 #토마토로부터 1일간 영향을 받으므로 전의 값보다 1 더해줌
                queue.append([az, ax, ay])

    days = 0
    for p in box:
        for line in p:
            for t in line:
                if t == 0: # 영향을 받지 않은 토마토가 있는 경우 
                    return -1
            days = max(days, max(line))

    return days - 1 #1부터 1씩 더하므로 마지막에 1 빼줌

for i in range(H):
    box.append(list())
    for j in range(N):
        box[i].append(list(map(int, input().split())))
        for k in range(M):
            if box[i][j][k] == 1:
                queue.append([i, j, k])

print(bfs())


