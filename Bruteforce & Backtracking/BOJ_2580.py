#2580
import sys
map = [list(map(int, sys.stdin.readline().split())) for _ in range(9)]
t = ()
def check():
    for i in range(9):
        for j in range(9):
            if map[i][j] == 0:
                t = (i, j)
                return t
    else:
        t = (-1, -1)
        return t

def case(i, j, num):
    for n in range(9):
        if map[n][j] == num:
            return False
    for n in range(9):
        if map[i][n] == num:
            return False
    i = i // 3
    j = j // 3
    for n in range(3 * i, 3 * i + 3):
        for m in range(3 * j, 3 * j + 3):
            if map[n][m] == num:
                return False
    return True

def dfs():
    (i, j) = check()
    if (i, j) == (-1, -1):
        for i in range(9):
            for j in range(9):
                print(map[i][j], end = ' ')
            print()
        exit(0)
    for num in range(1, 10):
        if case(i, j, num):
            map[i][j] = num
            dfs()
            map[i][j] = 0

dfs()