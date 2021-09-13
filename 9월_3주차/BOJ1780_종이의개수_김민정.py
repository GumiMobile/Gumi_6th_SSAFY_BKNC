from sys import stdin
input = stdin.readline


# 종이가 모두 같은 수로 되어 있는지 검사
def check(sx, sy, n):
    tmp = paper[sx][sy]
    for i in range(n):
        for j in range(n):
            if paper[sx+i][sy+j] != tmp:
                return False

    return True


# 분할 정복
def divide_and_conquer(sx, sy, n):
    if check(sx, sy, n):
        res[paper[sx][sy] + 1] += 1
    else:
        for i in range(3):
            for j in range(3):
                divide_and_conquer(sx + i*n//3, sy + j*n//3, n//3)  # 종이를 9개씩 분할

    return


N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]
res = [0, 0, 0]

divide_and_conquer(0, 0, N)
for r in res:
    print(r)