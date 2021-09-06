T = int(input())
for t in range(1, T + 1):
    fees = list(map(int, input().split()))
    uses = list(map(int, input().split()))

    dp = [0 for _ in range(13)]
    dp[1] = min(fees[0] * uses[0], fees[1])
    dp[2] = dp[0] + min(fees[0] * uses[1], fees[1])
    dp[3] = min(dp[2] + min(fees[0] * uses[2], fees[1]), fees[2])

    for i in range(4, 13):
        dp[i] = min(dp[i-3] + fees[2], dp[i-1] + min(fees[0] * uses[i - 1], fees[1]))

    dp[-1] = min(dp[-1], fees[3])
    print(f'#{t} {dp[-1]}')