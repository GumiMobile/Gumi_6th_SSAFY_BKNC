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
        stack.append(paper[sx][sy])
    else:
        stack.append('(')
        for i in range(2):
            for j in range(2):
                divide_and_conquer(sx + i*n//2, sy + j*n//2, n//2)  # 종이를 4개씩 분할
        stack.append(')')

    return


N = int(input())
paper = [list(map(int, list(input())[:N])) for _ in range(N)]
stack = []

divide_and_conquer(0, 0, N)
for n in stack:
    print(n, end="")
print()