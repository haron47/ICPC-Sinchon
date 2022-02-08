N, M = map(int, input().split())
L = list(map(int, input().split()))

low = 0
high = max(L)

while(high >= low):
    sum = 0
    mid = (low + high) // 2
    if mid == 0:
        ans = 0
        break
    for i in range(M):
        temp = L[i]
        while(temp >= mid):
            sum += 1
            temp = temp - mid
        if sum >= N:
            break
    if sum >= N:
        ans = mid
        low = mid + 1
    else:
        high = mid -1

print(ans)