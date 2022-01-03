T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    village = [list(map(int, input().split())) for _ in range(N)]

    houses = []
    for r in range(N):
        for c in range(N):
            if village[r][c]:
                houses.append((r, c))

    res = 1
    for k in range(2, N + 2):
        for r in range(N):
            for c in range(N):

                cnt = 0
                for y, x in houses:
                    if abs(r - y) + abs(c - x) < k:
                        cnt += 1

                if cnt > res and cnt * M >= k**2 + (k-1)**2:
                    res = cnt

    print(f'#{t} {res}')