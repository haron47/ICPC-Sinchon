N, K = map(int, input().split())
seq = list(map(int, input().split()))
list = [0 for i in range(N)]
res = 0
idx = 0
list[idx] = seq[0]
res += 1
idx += 1

for i in range(1, N):
    cnt = 0
    for j in range(idx):
        if seq[i] > list[j]:
            cnt += 1
            a = j
            break
    if cnt == 0:
        list[idx] = seq[i]
        idx += 1
        res += 1
    elif cnt > 0:
        list[a] = seq[i]

if res > K:
    print('NO')
elif res <= K:
    print('YES')
