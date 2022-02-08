N = int(input())
case1= [False for i in range(2 * N)] #같은 열에 있는 경우
case2 = [False for i in range(2 * N)] #좌상대각
case3 = [False for i in range(2 * N)] #우상대각
cnt = 0

def solve(level):
    global cnt, N
    if level == N:
        cnt += 1
        return
    for i in range(N):
        if case1[i] + case2[i + level] + case3[level - i + N - 1] == 0:
            case1[i] = case2[i + level] = case3[level - i + N - 1] = True
            solve(level + 1)
            case1[i] = case2[i + level] = case3[level - i + N - 1] = False

solve(0)
print(cnt)
