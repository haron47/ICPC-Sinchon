N, M = map(int, input().split())
line = [int(input()) for i in range(N)]
low = 0
high = int(1e18)

while high >= low:
    sum = 0
    mid = (low + high) // 2
    for i in range(N):
        sum += mid // line[i]
        if sum >= M:
            break
    if sum < M:
        low = mid + 1
    else:
        ans = mid
        high = mid - 1
print(ans)

