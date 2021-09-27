from sys import stdin
input = stdin.readline

N, M = map(int, input().split())

array1 = [list(map(int, input().split())) for _ in range(N)]

M2, K = map(int, input().split())
array2 = [list(map(int, input().split())) for _ in range(M2)]

res = []
for i in range(len(array1)):
    tmp = []
    for j in range(len(array2[0])):
        s = 0
        for k in range(len(array1[0])):
            s += array1[i][k] * array2[k][j]
        tmp.append(s)
    res.append(tmp)

for row in res:
    for n in row:
        print(n, end=' ')
    print()