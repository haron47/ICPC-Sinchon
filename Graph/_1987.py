##1987 - 알파벳
import sys
R, C = map(int, sys.stdin.readline().split())
board = [[0 for _ in range(C)] for _ in range(R)]
visited = [False] * 26
MAX = -1
for i in range(R):
    str = sys.stdin.readline()
    for j in range(C):
        board[i][j] = ord(str[j]) - 65

def dfs(i, j, depth):
    global MAX
    now = board[i][j]
    visited[now] = True
    if i + 1 <= R - 1 and visited[board[i + 1][j]] == False:
        dfs(i + 1, j, depth + 1)
    if i - 1 >= 0 and visited[board[i - 1][j]] == False:   
        dfs(i - 1, j, depth + 1)
    if j + 1 <= C - 1 and visited[board[i][j + 1]] == False:     
        dfs(i, j + 1, depth + 1)
    if j - 1 >= 0 and visited[board[i][j - 1]] == False:    
        dfs(i, j - 1, depth + 1)
    visited[now] = False
    MAX = max(MAX, depth)

dfs(0, 0, 1)
print(MAX)