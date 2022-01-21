import sys

N = int(input())
list = list(map(int, input().split()))
list.sort()
sum = 0
min_sum = sys.maxsize

for i in range(N):
    sum = list[i] + list[2 * N - (i + 1)]
    min_sum = min(sum, min_sum)

print(min_sum)