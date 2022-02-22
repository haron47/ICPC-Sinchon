##2606 - 바이러스
import sys
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
arr = [[0 for _ in range(N + 1)] for _ in range(N + 1)]
visited = [0] * (N + 1)
for i in range(M):
    x, y = map(int, sys.stdin.readline().split())
    arr[x][y] = 1
    arr[y][x] = 1

def dfs(start):
    global res
    visited[start] = 1
    for i in range(1, N + 1):
        if(arr[start][i] == 1 and visited[i] == 0):
            res += 1
            dfs(i)

res = 0
dfs(1)
print(res)