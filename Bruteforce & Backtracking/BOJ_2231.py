N = int(input())
res = 0

for n in range(1, N):
    num = n
    sum = num
    while(num > 10):
        sum += num % 10
        num = num // 10
    sum += num
    if sum == N:
        res = n
        break
print(res)
        


