N, M = list(map(int, input().split()))
list = list(map(int, input().split()))
visit = [0 for _ in range(N)]
cnt = 0
sum = 0
list.sort()

def count(num):
    global M
    if(num == 10):
        return 1
    elif num > 10 and M > 0:
        M -= 1
        return 1 + count(num - 10)
    else:
        return 0

for idx in range(N):
    if(list[idx] % 10 == 0) and visit[idx] == 0:
        cnt += count(list[idx])
        visit[idx] = 1

for idx in range(N):
    if visit[idx] == 0:
        cnt += count(list[idx])
        visit[idx] = 1

print(cnt)