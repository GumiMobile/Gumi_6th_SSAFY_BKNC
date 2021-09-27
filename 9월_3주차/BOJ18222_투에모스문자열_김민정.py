from sys import stdin
input = stdin.readline

def thue_morse(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    if n % 2:
        return 1 - thue_morse(n//2)
    else:
        return thue_morse(n//2)

K = int(input())
print(thue_morse(K - 1))