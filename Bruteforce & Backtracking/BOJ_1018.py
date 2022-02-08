import sys
N, M = map(int, input().split())
board = [list(map(str,list(input()))) for _ in range(N)]

ans = sys.maxsize
for i in range(N - 7):
    for j in range(M - 7):
        case1 = 0 #B 짝수 W 홀수
        case2 = 0 #B 홀수 W 짝수
        for m in range(i, i + 8):
            for n in range(j, j + 8):
                if board[m][n] == 'B':
                    if (m + n) % 2 != 0:
                        case1 += 1
                    else:
                        case2 += 1
                else:
                    if (m + n) % 2 != 0:
                        case2 += 1
                    else:
                        case1 += 1
        ans = min(ans, case1, case2)
print(ans)
