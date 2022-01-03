from itertools import permutations

T = int(input())
for t in range(1, T+1):
    N = int(input())
    line = list(map(int, input().split()))
    company = line[0:2]
    home = line[2:4]
    customer = [[line[2*i+4], line[2*i+5]] for i in range(N)]

    res = float('inf')
    for root in permutations(customer): # 순열을 통해 방문할 수 있는 모든 경우의 수 구하여 비교
        subs = 0
        before = company
        for c in root:
            subs += abs(c[0] - before[0]) + abs(c[1] - before[1])
            before = c
        subs += abs(home[0] - before[0]) + abs(home[1] - before[1])
        res = min(res, subs)

        print(f'#{t} {res}')