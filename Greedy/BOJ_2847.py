N = int(input())
list = [int(input()) for _ in range(N)]
ans = 0

for idx in range(N - 1, 0, -1):
    if list[idx] <= list[idx - 1]:
        ans += list[idx - 1] - list[idx] + 1
        list[idx - 1] = list[idx] - 1

print(ans)
   

