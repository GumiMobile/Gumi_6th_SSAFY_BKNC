from sys import stdin
input = stdin.readline


# 분할 정복
def paint(sx, sy, n, flag):
    if n == 1:  # 크기가 1일 때 flag에 맞게 별 찍기
        if not flag:
            paper[sx][sy] = " "
        else:
            paper[sx][sy] = "*"
    else: # 3*3 분할
        for i in range(3):
            for j in range(3):
                if i == 1 and j == 1 and flag:  # 가운데 정사각형은 공백처리
                    paint(sx + i*n//3, sy + j*n//3, n//3, not flag)
                else:
                    paint(sx + i * n // 3, sy + j * n // 3, n // 3, flag)
    return


N = int(input())
paper = [['*'] * N for _ in range(N)]

paint(0, 0, N, True)
for n in paper:
    print("".join(n))
print()