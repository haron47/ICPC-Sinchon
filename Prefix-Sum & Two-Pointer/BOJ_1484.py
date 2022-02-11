import sys
G = int(sys.stdin.readline())
arr = [0] * 100001
for i in range(100001):
    arr[i] = i * i
res = [0] * 1000001
cnt = 0
low = 1
high = 1
sum = 0

while(1):
    sum = arr[high] - arr[low]
    if sum < G:
        high += 1
    else:
        low += 1
    if sum == G:
        res[cnt] = high
        cnt += 1
    if high == 100001:
        break
if cnt == 0:
    print(-1)
else:
    for i in range(cnt):
        print(res[i])

