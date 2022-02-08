N, M = map(int, input().split())
visited = [0 for i in range(N + 1)]
res = [0 for i in range(M)]

def dfs(start, depth):
    if depth == M:
        for i in range(M):
            print(res[i], end = ' ')
        print()
        return
    for i in range(start, N + 1):
        if visited[i] == 0:
            visited[i] = 1
            res[depth] = i 
            dfs(i, depth + 1)
            visited[i] = 0
dfs(1, 0)