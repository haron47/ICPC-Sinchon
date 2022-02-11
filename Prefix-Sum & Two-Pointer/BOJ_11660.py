import sys
N, M = map(int, sys.stdin.readline().split())
arr = [list(map(int,sys.stdin.readline().split())) for _ in range(N)]
pre = [[0 for j in range(N + 1)]for i in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + arr[i - 1][j - 1]

while M > 0:
    i, j, m ,n = map(int, sys.stdin.readline().split())
    ans = pre[m][n] - pre[m][j - 1] - pre[i - 1][n] + pre[i - 1][j - 1]
    print(ans)
    M -= 1