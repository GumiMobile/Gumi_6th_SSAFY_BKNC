T = int(input())
for t in range(1, T + 1):
    k = int(input())
    str = input()

    dict = set()
    for i in range(len(str)):
        for j in range(i+1, len(str) + 1):
            dict.add(str[i:j])

    newDict = sorted(dict)
    res = ""
    if k > len(newDict):
        res = "none"
    else:
        res = newDict[k-1]

    print(f'#{t} {res}')
