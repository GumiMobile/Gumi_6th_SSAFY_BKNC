from sys import stdin
input = stdin.readline


N, D = map(int, input().split())
short_path = [list(map(int, input().split())) for _ in range(N)]

path = [i for i in range(D+1)]
for i in range(D+1):
    if i > 0:
        path[i] = min(path[i], path[i-1]+1)
    
    for s, e, v in short_path:
        if i == s and e <= D and path[i]+v < path[e]:
            path[e] = path[i]+v

print(path[D])