import copy

def combination(arr, r): #nCr의 조합 생성
    arr = sorted(arr)
    global synerges

    def generate(chosen):
        if len(chosen) == r:
            synerges.append(copy.deepcopy(chosen))
            return

        start = arr.index(chosen[-1]) + 1 if chosen else 0
        for nxt in range(start, len(arr)):
            chosen.append(arr[nxt])
            generate(chosen)
            chosen.pop()

    generate([])


T = int(input())
for t in range(1, T + 1):
    N = int(input())
    ingredients = [list(map(int, input().split())) for _ in range(N)]

    foods = [i for i in range(N)]
    synerges = []

    synerge = float('inf')

    # 조합으로 N//2개씩 나누는 모든 경우의 수 생성
    combination(foods, N//2)

    for i in range(len(synerges) // 2):
        s = synerges[i]

        a_food = 0
        for j in range(N//2):
            food = s[j]
            for k in s:
                a_food += ingredients[food][k]

        s = synerges[-i-1]
        b_food = 0
        for j in range(N//2):
            food = s[j]
            for k in s:
                b_food += ingredients[food][k]

        synerge = min(synerge, abs(a_food - b_food))

    print(f'#{t} {synerge}')