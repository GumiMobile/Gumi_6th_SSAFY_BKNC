from sys import stdin
input = stdin.readline

def binary_search(left, right):
    ans = 0
    while left <= right:
        mid = (left+right)//2
        current = house[0]
        cnt = 1

        for i in range(1, len(house)):
            if house[i] >= current+mid:
                current = house[i]
                cnt += 1

        if cnt >= C:
            left = mid + 1
            ans = mid
        else:
            right = mid - 1

    return ans


N, C = map(int, input().split())
house = []
for _ in range(N):
    house.append(int(input()))

house = sorted(house)
left = 1
right = house[-1] - house[0]
print(binary_search(left, right))