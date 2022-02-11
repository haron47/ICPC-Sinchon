import sys
N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
pre = [0 for i in range(N + 1)]
for i in range(1, N + 1):
    pre[i] = pre[i - 1] + arr[i - 1]

while M > 0:
    i, j = map(int, sys.stdin.readline().split())
    ans = pre[j] - pre[i - 1]
    print(ans)
    M -= 1
