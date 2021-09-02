T = int(input())
for t in range(1, T + 1):
    case = list(input().split())
    inputs = list(input().split())

    strtonum = {'ZRO': 0, 'ONE': 1, 'TWO': 2, 'THR': 3, 'FOR': 4, 'FIV': 5, 'SIX': 6,
                'SVN': 7, 'EGT': 8, 'NIN': 9}

    numtostr = {0: "ZRO", 1: "ONE", 2: "TWO", 3: "THR", 4: "FOR", 5: "FIV", 6: "SIX",
                7: "SVN", 8: "EGT", 9: "NIN"}

    nums = []
    for i in inputs:
        nums.append(strtonum[i])

    nums = sorted(nums)
    res = ""
    for num in nums:
        res += numtostr[num] + " "

    print(f'#{t}')
    print(res)