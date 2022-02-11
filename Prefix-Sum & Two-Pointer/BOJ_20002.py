#20002 - 사과나무
import sys
N = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
pre = [[0 for j in range(N + 1)]for i in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        pre[i][j] = pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1] + arr[i - 1][j - 1]

res = -sys.maxsize - 1
for i in range(1, N + 1):
    for j in range(i, N + 1):
        for k in range(i, N + 1):
            temp = pre[j][k] - pre[j - i][k] - pre[j][k - i] + pre[j - i][k - i]
            res = max(res, temp)
print(res)