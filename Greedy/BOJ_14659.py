N = int(input())
list = list(map(int, input().split()))
ans = 0
cnt = 0
max_num = 0

for i in list:
    if max_num < i:
        max_num = i
        cnt = 0
    else:
        cnt += 1
    ans = max(ans, cnt)

print(ans)