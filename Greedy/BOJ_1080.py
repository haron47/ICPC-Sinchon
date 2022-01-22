N, M = map(int, input().split())
arr_A = [list(map(int,list(input()))) for _ in range(N)]
arr_B = [list(map(int,list(input()))) for _ in range(N)]
arr_C = [[arr_A[i][j] ^ arr_B[i][j] for j in range(M)] for i in range(N)]
cnt = 0

def sum():
    sum = 0
    for i in range(N):
        for j in range(M):
            sum += arr_C[i][j]
    return sum

def change(n, m):
    for i in range(n, n + 3):
        for j in range(m, m + 3):
           arr_C[i][j] = 1 - arr_C[i][j]

for i in range(0, N - 2):
    for j in range(0, M - 2):
        if  arr_C[i][j] == 1:
            change(i, j)
            cnt += 1

if sum() == 0:
        print(cnt)
else:
        print('-1')