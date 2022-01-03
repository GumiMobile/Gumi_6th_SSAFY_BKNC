import math
 
def cal(a, b, operator):
    if operator == 0:
        return a+b
    elif operator == 1:
        return a-b
    elif operator == 2:
        return a*b
    elif operator == 3:
        if b != 0:
            return math.trunc(a / b)
 
 
def dfs(idx, ans):
    if idx >= N - 1:
        global max_n, min_n
        if ans > max_n:
            max_n = ans
        if ans < min_n:
            min_n = ans
        return
 
    for i in range(4):
        if op_cnt[i]:
            op_cnt[i] -= 1
            dfs(idx+1, cal(ans, nums[idx+1], i))
            op_cnt[i] += 1
 
 
op = ['+', '-', '*', '/']
T = int(input())
for t in range(1, T + 1):
    N = int(input())
    op_cnt = list(map(int, input().split()))
    nums = list(map(int, input().split()))
 
    max_n = float('-inf')
    min_n = float('inf')
 
    dfs(0, nums[0])
    res = max_n - min_n
 
    print(f'#{t} {res}')