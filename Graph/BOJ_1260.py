import sys
N, M , V = map(int, sys.stdin.readline().split())
graph = [[0 for j in range(N + 1)] for i in range(N + 1)]
visited = [0] * (N + 1)
queue = []

for i in range(M):
    e1, e2 = map(int, sys.stdin.readline().split())
    graph[e1][e2] = 1
    graph[e2][e1] = 1

def dfs(start):
    visited[start] = 1
    print(start, end = ' ')
    for i in range(1, N + 1):
        if(graph[start][i] == 1 and visited[i] == 0):
            dfs(i)

def bfs(start):
    visited[start] = 1
    queue.append(start)
    while(len(queue)):
        temp = queue.pop(0)
        print(temp, end = ' ')
        for i in range(1, N + 1):
            if(graph[temp][i] == 1 and visited[i] == 0):
                queue.append(i)
                visited[i] = 1

dfs(V)
visited = [0] * (N + 1)
print()
bfs(V)


