#10025 - 게으른 백곰
import sys
N, K = map(int, sys.stdin.readline().split())
arr = [0] * 1000001
MIN = 1000001
MAX = -1
for i in range(N):
    g, x = map(int,sys.stdin.readline().split())
    arr[x] = g
    MIN = min(MIN, x)
    MAX = max(MAX, x)
low = MIN
now = min(MIN + K, MAX)
high = min(now + K, MAX)
res = 0
temp = 0
for i in range(low, high + 1):
    temp += arr[i]

while True:
    res  = max(res , temp)
    now += 1
    temp -= arr[low]
    low = now - K
    if(high == MAX):
        break
    high = min(now + K, MAX)
    temp += arr[high]

res  = max(res , temp)
print(res)

