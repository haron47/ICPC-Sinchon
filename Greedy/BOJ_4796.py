cnt = 1 #case 개수
while True : 
    L, P, V = map(int, input().split())
    if L + P + V == 0: 
        break

    remainder = V % P
    sum = V // P * L + min(remainder, L)
    print('Case ', cnt, ': ', sum)
    cnt += 1