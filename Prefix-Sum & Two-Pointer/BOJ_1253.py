import sys
N = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
A.sort()
cnt = 0
for i in range(N):
    low = 0
    high = N - 1
    sum = 0
    while(1):
        if low == i:
            low += 1
        if high == i:
            high -= 1
        if high == low:
            break
        sum = A[low] + A[high]
        if sum == A[i]:
            cnt += 1
            break
        elif sum < A[i]:
            low += 1
        else:
            high -= 1
 
print(cnt)                                       