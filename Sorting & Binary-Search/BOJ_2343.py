#2343 - 기타레슨
N, M = map(int, input().split())
L = list(map(int, input().split()))

low = max(L)
high = max(L) * N

while high >= low:
    temp = 0
    sum = 0
    mid = (low + high) // 2
    for i in range(N):
        temp += L[i]
        if temp > mid:
            sum += 1
            temp = L[i]
        if sum >= M:
            break
    sum += 1
    if sum >= M + 1:
        low = mid + 1
    else:
        ans = mid
        high = mid - 1
print(ans)