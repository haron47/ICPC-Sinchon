N = int(input())
list = [list(map(int, input().split())) for _ in range(N)]
list.sort(key = lambda x:(x[1], x[0]))
end = 0
cnt = 0

for i in range(N):
    if(end <= list[i][0]):
        end = list[i][1]
        cnt += 1
print(cnt)