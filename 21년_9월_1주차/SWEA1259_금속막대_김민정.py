def dfs(idx):
    global maxLen
    global tmp

    for e in range(N):
        if visited[e] == 0 and sorted_screws[e][0] == idx:
            visited[e] = 1
            tmp.append(sorted_screws[e][0])
            tmp.append(sorted_screws[e][1])

            dfs(sorted_screws[e][1])

    if len(maxLen) < len(tmp):
        maxLen = tmp

    return


T = int(input())
for t in range(1, T+1):
    N = int(input())
    screws = []
    tmp = list(map(int, input().split()))

    for i in range(N):
        screws.append([tmp[2*i], tmp[2*i+1]])

    sorted_screws = sorted(screws, key=lambda x: x[0])
    print(sorted_screws)

    maxLen = []
    for idx, screw in enumerate(sorted_screws):
        tmp = screw
        visited = [0] * N
        visited[idx] = 1
        dfs(screw[1])
        visited[idx] = 0

    print(f'#{t}', end=" ")
    for i in maxLen:
        print(i, end=" ")
    print()