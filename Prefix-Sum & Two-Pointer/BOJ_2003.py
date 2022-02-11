import sys
N, M = map(int, sys.stdin.readline().split())
A = list(map(int, sys.stdin.readline().split()))

low = 0
high = 0
sum = 0
cnt = 0
while(high < N):
    if sum < M:
        sum += A[high]
        high += 1
    else:
        sum -= A[low]
        low += 1
    if sum == M:
        cnt += 1
print(cnt)